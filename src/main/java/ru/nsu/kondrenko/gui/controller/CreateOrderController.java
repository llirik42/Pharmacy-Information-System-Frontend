package ru.nsu.kondrenko.gui.controller;

import ru.nsu.kondrenko.model.services.orders.OrderService;

import java.awt.event.ActionEvent;

public class CreateOrderController extends OptionController {
    private final OrderService orderService;

    public CreateOrderController(String optionName, OrderService orderService) {
        super(optionName);
        this.orderService = orderService;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        super.actionPerformed(actionEvent);
    }
}
