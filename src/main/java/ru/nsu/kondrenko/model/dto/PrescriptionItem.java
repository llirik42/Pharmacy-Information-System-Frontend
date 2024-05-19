package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionItem {
    private Drug drug;

    @JsonAlias("amount")
    private int drugAmount;

    @JsonAlias("administration_route")
    private AdministrationRoute administrationRoute;
}
