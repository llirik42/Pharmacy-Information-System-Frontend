package ru.nsu.kondrenko.gui.controller;

import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.utils.DialogPanel;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;
import ru.nsu.kondrenko.model.services.orders.response.OrderObtainResponse;
import ru.nsu.kondrenko.model.services.orders.response.OrderObtainStatus;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ObtainOrderController extends OptionController {
    private final OrderService orderService;

    private final JTextField orderIdField;
    private final DialogPanel dialogPanel;

    @Setter
    private View view;

    public ObtainOrderController(String optionName, OrderService orderService) {
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

            final OrderObtainResponse response = orderService.obtainOrder(orderId);
            final OrderObtainStatus status = response.getStatus();

            switch (status) {
                case SUCCESS -> view.showInfo("Заказ успешно забран");

                case NOT_FOUND -> {
                    view.showError("Заказ не найден");
                    actionPerformed(actionEvent);
                }

                case CANNOT_BE_OBTAINED -> view.showError("Заказ нельзя забрать");

                case ALREADY_OBTAINED -> view.showError("Заказ уже забран");
            }
        } catch (NumberFormatException exception) {
            view.showError("Некорректный номер заказа");
            actionPerformed(actionEvent);
        } catch (OrderServiceException exception) {
            view.showNoConnectionError();
        }
    }
}
