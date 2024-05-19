package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;

    private Prescription prescription;

    @JsonProperty("registration_datetime")
    private Date registrationDatetime;

    @JsonProperty("appointed_datetime")
    private Date appointedDatetime;

    @JsonProperty("obtaining_datetime")
    private Date obtainingDatetime;

    @JsonProperty("paid")
    private boolean isPaid;

    private Customer customer;
}
