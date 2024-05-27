package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortPrescriptionItem {
    @JsonProperty("drug_id")
    private int drugId;

    private int amount;

    @JsonProperty("administration_route_id")
    private int administrationRouteId;
}
