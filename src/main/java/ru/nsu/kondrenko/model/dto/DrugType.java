package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugType {
    private int id;

    private String name;

    @JsonProperty("cookable")
    private boolean isCookable;
}
