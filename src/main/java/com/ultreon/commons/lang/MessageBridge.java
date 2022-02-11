package com.ultreon.commons.lang;

import java.util.function.Consumer;

/**
 * @author Qboi
 * @since 1.0.0
 */
public class MessageBridge implements ILogger {
    private final Consumer<String> consumer;

    public MessageBridge(Consumer<String> consumer) {
        this.consumer = consumer;
    }

    public void message(String message) {
        this.consumer.accept(message);
    }

    @Deprecated
    @Override
    public final void log(String message) {
        message(message);
    }
}
