package org.datacleaner.extension.sendjmsmessage;

import java.util.Collection;
import java.util.Collections;

import org.datacleaner.api.AnalyzerResult;
import org.datacleaner.api.Metric;

/**
 * Result class for {@link Analyzer}s that sends messages to JMS queue.
 */
public class SendMessageToJMSQueueAnalyzerResult implements AnalyzerResult {

    private static final long serialVersionUID = 1L;

    private final int _successCount;
    private final int _skipCount;
    private final Collection<SendMessageToJMSQueueResult> _failures;

    /**
     * Constructor.
     * 
     * @param successCount
     * @param skipCount
     * @param failures
     */
    public SendMessageToJMSQueueAnalyzerResult(int successCount, int skipCount, Collection<SendMessageToJMSQueueResult> failures) {
        _successCount = successCount;
        _skipCount = skipCount;
        _failures = failures;
    }

    /**
     * Returns failures.
     * 
     * @return
     */
    public Collection<SendMessageToJMSQueueResult> getFailures() {
        return Collections.unmodifiableCollection(_failures);
    }

    /**
     * Returns rows skipped count.
     * 
     * @return
     */
    @Metric(value = "Messages skipped")
    public int getSkipCount() {
        return _skipCount;
    }

    /**
     * Returns success count.
     * 
     * @return
     */
    @Metric(value = "Messages sent")
    public int getSuccessCount() {
        return _successCount;
    }

    /**
     * Returns failure count.
     * 
     * @return
     */
    @Metric(value = "Messages failed to send")
    public int getFailureCount() {
        if (_failures == null) {
            return 0;
        }
        return _failures.size();
    }
}
