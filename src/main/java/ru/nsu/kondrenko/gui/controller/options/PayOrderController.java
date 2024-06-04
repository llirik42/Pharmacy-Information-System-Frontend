package ru.nsu.kondrenko.gui.controller.options;

import lombok.Setter;
import ru.nsu.kondrenko.gui.View;
import ru.nsu.kondrenko.gui.controller.OptionController;
import ru.nsu.kondrenko.gui.controller.utils.input.DialogPanel;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;
import ru.nsu.kondrenko.model.services.orders.response.OrderPaymentResponse;
import ru.nsu.kondrenko.model.services.orders.response.OrderPaymentStatus;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PayOrderController extends OptionController {
    private final OrderService orderService;

    private final JTextField orderIdField;
    private final DialogPanel dialogPanel;

    @Setter
    private View view;

    public PayOrderController(String optionName, OrderService orderService) {
        super(optionName);
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
