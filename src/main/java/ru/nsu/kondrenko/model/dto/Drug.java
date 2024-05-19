package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
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

    @JsonAlias("shelf_life")
    private int shelfLife;

    @JsonAlias("critical_amount")
    private int criticalAmount;

    @JsonAlias("drug_type")
    private DrugType drugType;

    private String description;
}
