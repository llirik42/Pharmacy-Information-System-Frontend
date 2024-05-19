package ru.nsu.kondrenko.model.services.orders.exceptions;

public class OrderServiceException extends Exception {
    public OrderServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
