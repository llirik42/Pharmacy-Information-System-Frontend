package ru.nsu.kondrenko.model.services.orders.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPaymentResponse {
    private OrderPaymentStatus status;
}
