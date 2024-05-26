package ru.nsu.kondrenko.model.services.orders.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderObtainResponse {
    private OrderObtainStatus status;
}
