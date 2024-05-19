package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionItem {
    private Drug drug;

    @JsonProperty("amount")
    private int drugAmount;

    @JsonProperty("administration_route")
    private AdministrationRoute administrationRoute;
}
