package com.qacollaboration.exceptions;

public class InvalidPathForExcelException extends InvalidPathForFileExceptions{

    public InvalidPathForExcelException(String message) {
        super(message);
    }

    public InvalidPathForExcelException(String message, Throwable cause) {
        super(message, cause);
    }
}
