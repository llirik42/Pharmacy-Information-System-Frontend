package ru.nsu.kondrenko.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionItem {
    private Drug drug;

    private int drugAmount;

    private AdministrationRoute administrationRoute;
}
