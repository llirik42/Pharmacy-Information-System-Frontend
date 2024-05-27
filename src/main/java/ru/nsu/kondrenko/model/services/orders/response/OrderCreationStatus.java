package ru.nsu.kondrenko.model.services.orders.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrderCreationStatus {
    @JsonProperty("success")
    SUCCESS,

    @JsonProperty("invalid")
    INVALID
}
