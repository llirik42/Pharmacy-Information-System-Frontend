package ru.nsu.kondrenko.model.services.orders.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.kondrenko.model.dto.Order;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSearchResponse {
    private Order order;
}
