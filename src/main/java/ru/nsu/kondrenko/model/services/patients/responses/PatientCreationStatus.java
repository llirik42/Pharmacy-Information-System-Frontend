package ru.nsu.kondrenko.model.services.patients.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PatientCreationStatus {
    @JsonProperty("success")
    SUCCESS,

    @JsonProperty("already_exists")
    ALREADY_EXISTS
}
