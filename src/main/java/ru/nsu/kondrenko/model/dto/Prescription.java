package ru.nsu.kondrenko.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    private String diagnosis;

    private Patient patient;

    private Doctor doctor;

    private List<PrescriptionItem> items;
}
