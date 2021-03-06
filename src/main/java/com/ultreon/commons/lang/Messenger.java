package com.ultreon.commons.lang;

import java.util.function.Consumer;

/**
 * @author Qboi
 * @since 1.0.0
 */
public class Messenger {
    private final Consumer<String> consumer;

    public Messenger(Consumer<String> consumer) {
        this.consumer = consumer;
    }

    public void send(String message) {
        this.consumer.accept(message);
    }
}
