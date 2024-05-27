package ru.nsu.kondrenko.model.services.doctors.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DoctorCreationStatus {
    @JsonProperty("success")
    SUCCESS,

    @JsonProperty("already_exists")
    ALREADY_EXISTS
}
