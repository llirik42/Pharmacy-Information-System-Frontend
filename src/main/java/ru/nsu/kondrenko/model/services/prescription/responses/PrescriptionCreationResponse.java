package ru.nsu.kondrenko.model.services.prescription.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionCreationResponse {
    private PrescriptionCreationStatus status;

    @JsonProperty("prescription_id")
    private int prescriptionId;
}
