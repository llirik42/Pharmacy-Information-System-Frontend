package ru.nsu.kondrenko.model.services.prescription.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PrescriptionCreationStatus {
    @JsonProperty("success")
    SUCCESS,

    @JsonProperty("invalid")
    INVALID
}
