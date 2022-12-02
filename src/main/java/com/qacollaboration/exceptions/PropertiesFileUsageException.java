package com.qacollaboration.exceptions;

public class PropertiesFileUsageException extends InvalidPathForFileExceptions{
    public PropertiesFileUsageException(String message) {
        super(message);
    }

    public PropertiesFileUsageException(String message, Throwable cause) {
        super(message, cause);
    }
}
