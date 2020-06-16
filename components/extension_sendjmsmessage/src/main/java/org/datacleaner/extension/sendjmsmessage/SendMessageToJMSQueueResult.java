package org.datacleaner.extension.sendjmsmessage;

import java.io.Serializable;

/**
 * Result object for the {@link SendMessageToJMSQueueAnalyzer}
 *
 */
public class SendMessageToJMSQueueResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final SendMessageToJMSQueueResult SUCCESS = new SendMessageToJMSQueueResult(true, null, null);

    /**
     * Success result.
     * 
     * @return
     */
    public static SendMessageToJMSQueueResult success() {
        return SUCCESS;
    }

    /**
     * Result for failure scenario.
     * 
     * @param to
     * @param e
     * @return
     */
    public static SendMessageToJMSQueueResult failure(String to, Exception e) {
        return new SendMessageToJMSQueueResult(false, to, e);
    }

    private final boolean _successful;
    private final Exception _error;
    private final String _messageIdentifier;

    private SendMessageToJMSQueueResult(boolean success, String messageId, Exception e) {
        _successful = success;
        _messageIdentifier = messageId;
        _error = e;
    }

    /**
     * Returns message Identifier.
     * 
     * @return
     */
    public String getMessageIdentifier() {
        return _messageIdentifier;
    }

    /**
     * Returns success status.
     * 
     * @return
     */
    public boolean isSuccessful() {
        return _successful;
    }

    /**
     * Returns error.
     * 
     * @return
     */
    public Exception getError() {
        return _error;
    }
}
