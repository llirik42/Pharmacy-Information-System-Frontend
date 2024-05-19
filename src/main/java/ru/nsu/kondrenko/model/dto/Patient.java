package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private int id;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("birthday")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
}
