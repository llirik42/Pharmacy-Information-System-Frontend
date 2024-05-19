package ru.nsu.kondrenko.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionComponent {
    private Drug component;

    private int componentAmount;
}
