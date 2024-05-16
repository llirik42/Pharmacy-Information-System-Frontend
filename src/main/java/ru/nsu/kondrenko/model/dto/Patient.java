package ru.nsu.kondrenko.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Patient {
    private String fullName;

    private Date birthDate;
}
