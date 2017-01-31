package com.brinkus.labs.skeleton.exception;

/**
 * Top level Exception for all service related exceptions.
 */
public class ServiceException extends Exception {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
