package ru.nsu.kondrenko.gui.controller.options;

import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.OptionController;
import ru.nsu.kondrenko.gui.controller.utils.input.DialogPanel;
import ru.nsu.kondrenko.gui.view.central.OrderInfoPanel;
import ru.nsu.kondrenko.model.dto.Order;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class OrderInfoController extends OptionController {
    private final OrderService orderService;

    private final JTextField orderIdField;
    private final DialogPanel dialogPanel;

    @Setter
    private OrderInfoPanel orderInfoPanel;

    public OrderInfoController(String optionName, OrderService orderService) {
        super(optionName);

        this.orderService = orderService;
        orderIdField = new JTextField();
        dialogPanel = new DialogPanel(1);
        dialogPanel.addComponent("Номер заказа", orderIdField);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        final boolean ok = getView().showConfirmationDialog("Данные для поиска", dialogPanel);
        if (!ok) {
            return;
        }

        try {
            final int orderId = Integer.parseInt(orderIdField.getText());
            final Order order = orderService.findOrder(orderId);

            if (order == null) {
                getView().showInfo("Заказ не найден");
                return;
            }

            orderInfoPanel.update(order);
            getView().showOrderInfo();
            setLabel();
        } catch (NumberFormatException exception) {
            getView().showError("Некорректный номер заказа");
            actionPerformed(actionEvent);
        } catch (OrderServiceException exception) {
            getView().showNoConnectionError();
        }
    }
}
