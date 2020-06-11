package org.datacleaner.extension.emailing;
import org.datacleaner.api.Analyzer;
import org.datacleaner.api.Concurrent;
import org.datacleaner.api.Configured;
import org.datacleaner.api.Description;
import org.datacleaner.api.ExternalDocumentation;
import org.datacleaner.api.ExternalDocumentation.DocumentationLink;
import org.datacleaner.api.ExternalDocumentation.DocumentationType;
import org.datacleaner.api.Initialize;
import org.datacleaner.api.InputColumn;
import org.datacleaner.api.InputRow;
import org.datacleaner.api.Provided;
import com.google.common.base.Strings;

import org.datacleaner.api.*;
import org.datacleaner.storage.RowAnnotationFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wuyongjun
 */
@Named("SendEmailUsingValueAnalyzer.name")
@Description("SendEmailUsingValueAnalyzer.Description")
@Concurrent(true)
public class SendEmailUsingValueAnalyzer implements Analyzer<SendEmailAnalyzerResult> {

    private static final Logger logger = LoggerFactory.getLogger(SendEmailUsingValueAnalyzer.class);


    @Inject
    @Provided
    RowAnnotationFactory rowAnnotationFactory;

    @Inject
    @Configured(value = "To (email address)", order = 1)
    InputColumn<String> emailAddressColumn;


    @Inject
    @Configured(value = "From (email address)", order = 2)
    String from = "Your name <your@email.com>";
    @Inject
    @Configured(value = "Email subject", order = 3)
    InputColumn<String> subject;
    @Inject
    @Configured(value = "Email body", order = 4)
    InputColumn<String> body;
    @Inject
    @Configured(value = "HTML email", order = 5)
    boolean htmlEmail = false;
    @Inject
    @Configured(value = "SMTP host", order = 6)
    String smtpHost = "smtp.gmail.com";
    @Inject
    @Configured(value = "SMTP port", order = 7)
    int smtpPort = 8;
    @Inject
    @Configured(order = 9)
    boolean tls = true;
    @Inject
    @Configured(order = 10)
    boolean ssl = false;
    @Inject
    @Configured(value = "SMTP username", order = 11)
    String smtpUsername;
    @Inject
    @Configured(value = "SMTP password", order = 12)
    @StringProperty(password = true)
    String smtpPassword;
    @Inject
    @Configured(order = 13)
    @Description("Sleep/wait time in milliseconds between every sent email. Negative value will allow concurrent sending, 0 will mean sequential sending with no delay.")
    long sleepTimeInMillis = -1;

    @Inject
    @Provided
    ComponentContext _componentContext;

    private EmailDispatcher _emailDispatcher;
    private AtomicInteger _successCount;
    private AtomicInteger _skipCount;
    private Collection<EmailResult> _failures;

    public SendEmailUsingValueAnalyzer() {
        init();
    }

    @Initialize
    public void init() {
        _emailDispatcher = new EmailDispatcher(smtpHost, smtpPort, smtpUsername, smtpPassword, from, tls, ssl);
        _successCount = new AtomicInteger();
        _skipCount = new AtomicInteger();
        _failures = new ConcurrentLinkedQueue<EmailResult>();
    }

    @Override
    public void run(InputRow row, int distinctCount) {
        final String subjectString = row.getValue(subject);
        final String emailAddressValue = row.getValue(emailAddressColumn);
        final String bodyString = row.getValue(body);

        if (Strings.isNullOrEmpty(emailAddressValue) || emailAddressValue.indexOf('@') == -1) {
            logger.info("Skipping invalid email: {}", emailAddressValue);
            _skipCount.incrementAndGet();
            return;
        }

        final EmailResult result = _emailDispatcher.sendMail(emailAddressValue, subjectString, "UTF-8", bodyString,
                null, sleepTimeInMillis);
        if (result.isSuccessful()) {
            _successCount.incrementAndGet();
        } else {
            _failures.add(result);

            // report to the execution log
            final Exception error = result.getError();
            _componentContext.publishMessage(new ExecutionLogMessage("Sending of email to '" + result.getRecipient()
                    + " failed! " + (error == null ? "" : error.getMessage())));
        }
    }

    @Override
    public SendEmailAnalyzerResult getResult() {
        return new SendEmailAnalyzerResult(_successCount.get(), _skipCount.get(), _failures);
    }

}
