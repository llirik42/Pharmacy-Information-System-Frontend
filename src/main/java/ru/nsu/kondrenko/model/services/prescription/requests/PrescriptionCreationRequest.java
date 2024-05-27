package ru.nsu.kondrenko.model.services.prescription.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.kondrenko.model.dto.ShortPrescriptionItem;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionCreationRequest {
    private String diagnosis;

    @JsonProperty("patient_id")
    private int patientId;

    @JsonProperty("doctor_id")
    private int doctorId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private List<ShortPrescriptionItem> items;
}
