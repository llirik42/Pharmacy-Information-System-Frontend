package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @JsonAlias("full_name")
    private String fullName;

    @JsonAlias("phone_number")
    private String phoneNumber;

    private String address;
}
