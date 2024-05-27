package ru.nsu.kondrenko.model.services.patients.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientCreationResponse {
    private PatientCreationStatus status;

    @JsonProperty("patient_id")
    private int patientId;
}
