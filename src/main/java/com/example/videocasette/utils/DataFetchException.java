package com.example.videocasette.utils;

public class DataFetchException extends Exception {

    public DataFetchException(String errorMessage) {
        super(errorMessage);
    }

    public DataFetchException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
