package ru.nsu.kondrenko.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoredDrug {
    private Drug drug;

    @JsonAlias("stored_number")
    private int storedNumber;
}
