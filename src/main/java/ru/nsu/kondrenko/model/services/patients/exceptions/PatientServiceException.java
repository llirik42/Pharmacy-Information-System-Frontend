package ru.nsu.kondrenko.model.services.patients.exceptions;

public class PatientServiceException extends Exception {
    public PatientServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
