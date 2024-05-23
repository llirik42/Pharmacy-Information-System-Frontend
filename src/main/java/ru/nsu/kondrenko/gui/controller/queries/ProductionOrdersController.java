package ru.nsu.kondrenko.gui.controller.queries;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.dto.Order;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@RequiredArgsConstructor
public class ProductionOrdersController implements ActionListener {
    private final OrderService orderService;

    private final Filler filler;

    @Setter
    private View view;

    @Setter
    private JTable table;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            final List<Order> ordersInProduction = orderService.getOrdersInProduction();
            filler.fillTable(table, ordersInProduction.toArray());

            if (ordersInProduction.isEmpty()) {
                view.showInfo("Заказы в производстве не найдены");
            }
        } catch (OrderServiceException ignored) {
            view.showNoConnectionError();
        }
    }
}
