package ru.nsu.kondrenko.model.services.prescription.exceptions;

public class PrescriptionServiceException extends Exception {
    public PrescriptionServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
