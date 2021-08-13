package org.datacleaner.extension.emailing;

import java.util.Collection;
import java.util.Collections;

import org.datacleaner.api.Analyzer;
import org.datacleaner.api.AnalyzerResult;
import org.datacleaner.api.Metric;

/**
 * Result class for {@link Analyzer}s that sends emails
 */
public class SendEmailAnalyzerResult implements AnalyzerResult {

    private static final long serialVersionUID = 1L;

    private final int _successCount;
    private final int _skipCount;
    private final Collection<EmailResult> _failures;

    public SendEmailAnalyzerResult(int successCount, int skipCount, Collection<EmailResult> failures) {
        _successCount = successCount;
        _skipCount = skipCount;
        _failures = failures;
    }

    public Collection<EmailResult> getFailures() {
        return Collections.unmodifiableCollection(_failures);
    }

    @Metric(value = "Emails skipped")
    public int getSkipCount() {
        return _skipCount;
    }

    @Metric(value = "Emails sent")
    public int getSuccessCount() {
        return _successCount;
    }

    @Metric(value = "Emails failed to send")
    public int getFailureCount() {
        if (_failures == null) {
            return 0;
        }
        return _failures.size();
    }
}
