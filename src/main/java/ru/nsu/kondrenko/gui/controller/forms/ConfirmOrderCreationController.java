package ru.nsu.kondrenko.gui.controller.forms;

import lombok.Setter;
import ru.nsu.kondrenko.gui.view.central.OrderCreationForm;
import ru.nsu.kondrenko.model.services.orders.OrderService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmOrderCreationController implements ActionListener {
    private final OrderService orderService;

    @Setter
    private OrderCreationForm orderCreationForm;

    public ConfirmOrderCreationController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
