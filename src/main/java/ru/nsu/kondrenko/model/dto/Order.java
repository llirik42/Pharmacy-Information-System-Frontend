package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
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

    @JsonAlias("registration_datetime")
    private Date registrationDatetime;

    @JsonAlias("appointed_datetime")
    private Date appointedDatetime;

    @JsonAlias("obtaining_datetime")
    private Date obtainingDatetime;

    @JsonAlias("paid")
    private boolean isPaid;

    private Customer customer;
}
