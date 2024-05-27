package ru.nsu.kondrenko.model.services.orders.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreationResponse {
    private OrderCreationStatus status;

    @JsonProperty("order_id")
    private int orderId;
}
