package ru.nsu.kondrenko.model.services.customers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreationResponse {
    private CustomerCreationStatus status;

    @JsonProperty("customer_id")
    private int customerId;
}
