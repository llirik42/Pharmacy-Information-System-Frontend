package ru.nsu.kondrenko.model.services.doctors.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorCreationRequest {
    @JsonProperty("full_name")
    private String fullName;
}
