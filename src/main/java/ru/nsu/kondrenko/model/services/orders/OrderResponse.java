package ru.nsu.kondrenko.model.services.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String message;

    private OrderStatus status;

    @JsonProperty("order_id")
    private int orderId;
}
