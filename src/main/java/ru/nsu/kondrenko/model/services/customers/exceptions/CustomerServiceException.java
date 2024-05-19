package ru.nsu.kondrenko.model.services.customers.exceptions;

public class CustomerServiceException extends Exception {
    public CustomerServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
