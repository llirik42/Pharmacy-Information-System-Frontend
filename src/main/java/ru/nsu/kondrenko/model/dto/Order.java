package ru.nsu.kondrenko.model.dto;

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

    private Date registrationDatetime;

    private Date appointedDatetime;

    private Date obtainingDatetime;

    private boolean isPaid;

    private Customer customer;
}
