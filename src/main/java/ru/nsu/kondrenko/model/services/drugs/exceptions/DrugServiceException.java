package ru.nsu.kondrenko.model.services.drugs.exceptions;

public class DrugServiceException extends Exception {
    public DrugServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
