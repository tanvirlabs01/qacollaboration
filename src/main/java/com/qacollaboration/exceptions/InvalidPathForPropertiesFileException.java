package com.qacollaboration.exceptions;

public class InvalidPathForPropertiesFileException extends InvalidPathForFileExceptions {

    public InvalidPathForPropertiesFileException(String message) {
        super(message);
    }

    public InvalidPathForPropertiesFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
