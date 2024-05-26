package ru.nsu.kondrenko.model.services.customers.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreationResponse {
    private CustomerCreationStatus status;
}
