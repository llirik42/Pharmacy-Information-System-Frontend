package ru.nsu.kondrenko.model.services.customers.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.kondrenko.model.dto.Customer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSearchResponse {
    private Customer customer;
}
