package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Technology {
    private int id;

    private Drug drug;

    @JsonProperty("cooking_time")
    private Time cookingTime;

    private int amount;

    private String description;

    private List<TechnologyComponent> components;
}
