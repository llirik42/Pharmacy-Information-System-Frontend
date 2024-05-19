package ru.nsu.kondrenko.model.services.doctors.exceptions;

public class DoctorServiceException extends Exception {
    public DoctorServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
