package ru.nsu.kondrenko.gui.controller.queries;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.services.orders.OrderService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@RequiredArgsConstructor
public class CreateOrderController implements ActionListener {
    private final OrderService orderService;

    @Setter
    private View view;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
