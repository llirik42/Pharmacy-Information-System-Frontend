package ru.nsu.kondrenko.model.services.orders.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreationRequest {
    @JsonProperty("prescription_id")
    private int prescriptionId;

    @JsonProperty("customer_id")
    private int customer_id;
}
