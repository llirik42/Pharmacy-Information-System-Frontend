package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyComponent {
    private Drug component;

    @JsonProperty("component_amount")
    private int componentAmount;
}
