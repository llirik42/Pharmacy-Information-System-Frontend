package ru.nsu.kondrenko.model.dto;

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

    private int shelfLife;

    private int criticalAmount;

    private DrugType drugType;

    private String description;
}
