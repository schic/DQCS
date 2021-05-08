package org.datacleaner.extension.sendjmsmessage;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.regex.Matcher;

import javax.inject.Named;

import org.apache.metamodel.util.FileHelper;

import org.apache.metamodel.util.Resource;
import org.datacleaner.api.Analyzer;
import org.datacleaner.api.Categorized;
import org.datacleaner.api.Close;
import org.datacleaner.api.ComponentContext;
import org.datacleaner.api.Concurrent;
import org.datacleaner.api.Configured;
import org.datacleaner.api.Description;
import org.datacleaner.api.ExecutionLogMessage;
import org.datacleaner.api.Initialize;
import org.datacleaner.api.InputColumn;
import org.datacleaner.api.InputRow;
import org.datacleaner.api.MappedProperty;
import org.datacleaner.api.Provided;
import org.datacleaner.api.Validate;
import org.datacleaner.components.categories.WriteSuperCategory;
import org.datacleaner.components.convert.ConvertToStringTransformer;

import com.google.common.base.Strings;

/**
 * Analyzer for sending messages to JMS queue.
 * 
 */
@Concurrent(true)
@Named("Send message to JMS queue")
@Description("Sends messages using a template file in which values can be dynamically merged into the message.")
@Categorized(superCategory = WriteSuperCategory.class)
public class SendMessageToJMSQueueAnalyzer implements Analyzer<SendMessageToJMSQueueAnalyzerResult> {

    private static final String PROPERTY_INPUT_COLUMNS = "Values";
    private static final String PROPERTY_FIELD_NAMES = "Fields";

    @Configured(PROPERTY_INPUT_COLUMNS)
    InputColumn<?>[] values;

    @Configured(PROPERTY_FIELD_NAMES)
    @MappedProperty(PROPERTY_INPUT_COLUMNS)
    String[] fields;

    @Configured
    InputColumn<?> idColumn;

    @Configured(value = "Broker url", order = 100)
    String brokerUrl;

    @Configured(value = "JMS queue name", order = 101)
    String jmsQueueName;

    @Configured(value = "Message template", required = true)
    Resource messageTemplate;

    @Configured
    String templateEncoding = "UTF-8";

    @Configured
    boolean includeTemplateAsHeader = true;

    @Provided
    ComponentContext _componentContext;

    private String _messageTemplateString;
    private JMSMessageToQueueSender _jmsMessageSender;
    private AtomicInteger _successCount;
    private AtomicInteger _skipCount;
    private Collection<SendMessageToJMSQueueResult> _failures;

    /**
     * Performs validation.
     */
    @Validate
    public void validate() {
        if (messageTemplate == null) {
            throw new IllegalStateException("Message template needs to be provided");
        }
    }

    /**
     * Initialize
     */
    @Initialize
    public void init() {
        _messageTemplateString = loadTemplate(messageTemplate);
        try {
            _jmsMessageSender = new JMSMessageToQueueSender(brokerUrl, jmsQueueName);
        } catch (Exception e) {
            throw new IllegalStateException("JMS sender could not be initialized", e);
        }
        _successCount = new AtomicInteger();
        _skipCount = new AtomicInteger();
        _failures = new ConcurrentLinkedQueue<SendMessageToJMSQueueResult>();
    }

    private String loadTemplate(Resource res) {
        if (res == null) {
            return null;
        }
        return res.read(new Function<InputStream, String>() {
            @Override
            public String apply(InputStream is) {
                return FileHelper.readInputStreamAsString(is, templateEncoding);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(InputRow row, int distinctCount) {
        final List<Object> rowValues = row.getValues(values);

        final String messageBody = buildMessageBodyFromTemplate(_messageTemplateString, fields, rowValues);
        final String id = ConvertToStringTransformer.transformValue(row.getValue(idColumn));

        final SendMessageToJMSQueueResult result = _jmsMessageSender.sendMessage(brokerUrl, jmsQueueName, messageBody,
                id);
        if (result.isSuccessful()) {
            _successCount.incrementAndGet();
        } else {
            _failures.add(result);

            // report to the execution log
            final Exception error = result.getError();
            _componentContext.publishMessage(new ExecutionLogMessage("Sending Message '"
                    + result.getMessageIdentifier() + " failed! " + (error == null ? "" : error.getMessage())));
        }
    }

    protected String buildMessageBodyFromTemplate(String messageTemplateString, String[] keys, List<Object> values) {
        StringBuilder message = new StringBuilder();
        if (includeTemplateAsHeader) {
            message.append(messageTemplateString).append("\n");
        }

        if (messageTemplateString == null || keys == null || values == null) {
            return "";
        }
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            Object value = values.get(i);
            messageTemplateString = replaceAll(messageTemplateString, key, value);
        }
        message.append(messageTemplateString);
        return message.toString();
    }

    /**
     * Does a plain text replacement
     * 
     * @param template
     * @param key
     * @param value
     * @return
     */
    private String replaceAll(String template, String key, Object value) {
        if (Strings.isNullOrEmpty(key.trim())) {
            return template;
        }

        if (value == null) {
            value = "";
        }
        final String valueQuoteReplacement = Matcher.quoteReplacement(value.toString());

        // template is not null, no check needed
        return template.replaceAll(key, valueQuoteReplacement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SendMessageToJMSQueueAnalyzerResult getResult() {
        return new SendMessageToJMSQueueAnalyzerResult(_successCount.get(), _skipCount.get(), _failures);
    }

    /**
     * Close the resources.
     */
    @Close
    public void close() {
        try {
            if (_jmsMessageSender != null) {
                _jmsMessageSender.close();
            }
        } catch (Exception e) {
            throw new IllegalStateException("Stopping CamelContext failed", e);
        }
    }
}
