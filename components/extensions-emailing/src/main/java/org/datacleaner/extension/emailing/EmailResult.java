package org.datacleaner.extension.emailing;

import java.io.Serializable;

public class EmailResult implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private static final EmailResult SUCCESS = new EmailResult(true, null, null);
    
    public static EmailResult success() {
        return SUCCESS;
    }
    
    public static EmailResult failure(String to, Exception e) {
        return new EmailResult(false, to, e);
    }

    private final boolean _successful;
    private final Exception _error;
    private final String _recipient;

    private EmailResult(boolean success, String to, Exception e) {
        _successful = success;
        _recipient = to;
        _error = e;
    }
    
    public String getRecipient() {
        return _recipient;
    }
    
    public boolean isSuccessful() {
        return _successful;
    }
    
    public Exception getError() {
        return _error;
    }
}
