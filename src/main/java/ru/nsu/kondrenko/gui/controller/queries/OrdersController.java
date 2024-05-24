package ru.nsu.kondrenko.gui.controller.queries;

import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.model.services.orders.OrderService;

import java.util.List;

public class OrdersController extends QueryController {
    private final OrderService orderService;

    public OrdersController(Filler filler, String queryName, OrderService orderService) {
        super(filler, queryName);
        this.orderService = orderService;
    }

    @Override
    protected List<?> getResult() throws Exception {
        return orderService.getOrders();
    }
}
