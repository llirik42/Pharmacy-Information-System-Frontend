package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    private int id;

    private String diagnosis;

    private Patient patient;

    private Doctor doctor;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private List<PrescriptionItem> items;
}
