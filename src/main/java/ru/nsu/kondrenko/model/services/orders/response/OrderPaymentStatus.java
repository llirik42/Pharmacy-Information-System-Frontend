package ru.nsu.kondrenko.model.services.orders.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrderPaymentStatus {
    @JsonProperty("success")
    SUCCESS,

    @JsonProperty("not_found")
    NOT_FOUND,

    @JsonProperty("cannot_be_paid")
    CANNOT_BE_PAID,

    @JsonProperty("already_paid")
    ALREADY_PAID,
}
