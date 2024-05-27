package ru.nsu.kondrenko.model.services.patients.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientCreationRequest {
    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("birthday")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
}
