package ru.nsu.kondrenko.gui.controller.options;

import ru.nsu.kondrenko.gui.controller.OptionController;
import ru.nsu.kondrenko.model.services.orders.OrderService;

public class OrderInfoController extends OptionController {
    private final OrderService orderService;

    public OrderInfoController(String optionName, OrderService orderService) {
        super(optionName);

        this.orderService = orderService;
    }
}
