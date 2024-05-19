package ru.nsu.kondrenko.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Technology {
    private Drug drug;

    private int cookingTime;

    private int amount;

    private String description;

    private List<TechnologyComponent> components;
}
