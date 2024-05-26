package ru.nsu.kondrenko.model.services.customers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CustomerCreationStatus {
    @JsonProperty("success")
    SUCCESS,

    @JsonProperty("already_exists_or_invalid")
    ALREADY_EXISTS_OR_INVALID
}
