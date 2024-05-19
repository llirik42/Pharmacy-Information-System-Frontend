package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drug {
    private int id;

    private String name;

    private int cost;

    @JsonProperty("shelf_life")
    private int shelfLife;

    @JsonProperty("critical_amount")
    private int criticalAmount;

    @JsonProperty("drug_type")
    private DrugType drugType;

    private String description;
}
