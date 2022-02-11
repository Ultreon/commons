package com.ultreon.commons.lang;

/**
 * @author Qboi
 * @since 1.0.0
 */
public class LoggableProgress extends Progress {
    private final MessageBridge messageBridge;

    public LoggableProgress(MessageBridge messageBridge, int progress, int max) {
        super(progress, max);
        this.messageBridge = messageBridge;
    }

    public LoggableProgress(MessageBridge messageBridge, int max) {
        super(max);
        this.messageBridge = messageBridge;
    }

    public void log(String text) {
        messageBridge.message(text);
    }

    public void logIncrement(String text) {
        messageBridge.message(text);
    }
}
