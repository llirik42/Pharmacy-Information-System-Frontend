package ru.nsu.kondrenko.gui.controller;

import ru.nsu.kondrenko.model.services.orders.OrderService;

public class OrderInfoController extends OptionController {
    private final OrderService orderService;

    public OrderInfoController(String optionName, OrderService orderService) {
        super(optionName);

        this.orderService = orderService;
    }
}
