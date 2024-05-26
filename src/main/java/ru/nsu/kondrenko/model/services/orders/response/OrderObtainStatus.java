package ru.nsu.kondrenko.model.services.orders.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrderObtainStatus {
    @JsonProperty("success")
    SUCCESS,

    @JsonProperty("not_found")
    NOT_FOUND,

    @JsonProperty("cannot_be_obtained")
    CANNOT_BE_OBTAINED,

    @JsonProperty("already_obtained")
    ALREADY_OBTAINED,
}
