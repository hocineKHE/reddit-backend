package com.example.reddit.exceptions;

public class SpringRedditExceptions extends RuntimeException {

    public SpringRedditExceptions(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringRedditExceptions(String exMessage) {
        super(exMessage);
    }
}
