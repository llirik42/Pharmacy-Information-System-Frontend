package ru.nsu.kondrenko.gui.controller;

import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.utils.DialogPanel;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;
import ru.nsu.kondrenko.model.services.orders.response.OrderPaymentResponse;
import ru.nsu.kondrenko.model.services.orders.response.OrderPaymentStatus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayOrderController implements ActionListener {
    private final OrderService orderService;

    private final JTextField orderIdField;
    private final DialogPanel dialogPanel;

    @Setter
    private View view;

    public PayOrderController(OrderService orderService) {
        this.orderService = orderService;

        orderIdField = new JTextField();
        dialogPanel = new DialogPanel(1);
        dialogPanel.addComponent("Номер заказа", orderIdField);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        final boolean ok = view.showConfirmationDialog("Данные заказа", dialogPanel);
        if (!ok) {
            return;
        }

        try {
            final int orderId = Integer.parseInt(orderIdField.getText());

            final OrderPaymentResponse response = orderService.payOrder(orderId);
            final OrderPaymentStatus status = response.getStatus();

            switch (status) {
                case SUCCESS -> view.showInfo("Заказ успешно оплачен");

                case NOT_FOUND -> {
                    view.showError("Заказ не найден");
                    actionPerformed(actionEvent);
                }

                case CANNOT_BE_PAID -> view.showError("Заказ нельзя оплатить");

                case ALREADY_PAID -> view.showError("Заказ уже оплачен");
            }
        } catch (NumberFormatException exception) {
            view.showError("Некорректный номер заказа");
            actionPerformed(actionEvent);
        } catch (OrderServiceException exception) {
            view.showNoConnectionError();
        }
    }
}
