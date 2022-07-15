package com.bridgelabz;

public class StateCensusIoException extends Exception {
    public StateCensusIoException(String message) {
        super(message);
    }

    public enum exceptionType {
        NO_SUCH_FILE,
        INCORRECT_TYPE,
        DELIMITER_ISSUE,
        INVALID_HEADER
    }
}
