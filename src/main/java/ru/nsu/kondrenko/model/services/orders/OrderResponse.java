package ru.nsu.kondrenko.model.services.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String message;

    private OrderStatus status;

    private int orderId;
}
