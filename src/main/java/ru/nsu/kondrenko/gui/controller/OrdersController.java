package ru.nsu.kondrenko.gui.controller;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.dto.Order;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;

import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

@RequiredArgsConstructor
public class OrdersController implements ActionListener {
    private final OrderService orderService;

    @Setter
    private TableModel tableModel;

    @Setter
    private View view;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            final List<Order> orders = orderService.getOrders();

        } catch (OrderServiceException exception) {

        }
    }
}
