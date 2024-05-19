package ru.nsu.kondrenko.gui.controller;

import lombok.Setter;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.dto.Customer;
import ru.nsu.kondrenko.model.dto.Order;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrdersController implements ActionListener {
    private static final String[] COLUMNS = {
            "Идентификатор",
            "Дата регистрации",
            "Назначенная дата получения",
            "Дата получения",
            "Оплачен",
            "Рецепт",
            "Покупатель",
    };

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    private final OrderService orderService;

    @Setter
    private View view;

    @Setter
    private JTable table;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            final List<Order> orders = orderService.getOrders();
            final Object[][] data = new Object[orders.size()][COLUMNS.length];

            for (int i = 0; i < orders.size(); i++) {
                final Order order = orders.get(i);
                final Customer customer = order.getCustomer();
                final Date registrationDatetime = order.getRegistrationDatetime();
                final Date appointedDatetime = order.getAppointedDatetime();
                final Date obtainingDatetime = order.getObtainingDatetime();

                data[i][0] = order.getId();
                data[i][1] = getDateRepresentation(registrationDatetime);
                data[i][2] = getDateRepresentation(appointedDatetime);
                data[i][3] = getDateRepresentation(obtainingDatetime);
                data[i][4] = order.isPaid() ? "+" : "";
                data[i][5] = order.getPrescription().getId();
                data[i][6] = customer == null ? null : customer.getId();
            }

            table.setModel(new DefaultTableModel(data, COLUMNS));
        } catch (OrderServiceException exception) {
            view.showError(exception.getLocalizedMessage());
        }
    }

    private String getDateRepresentation(Date date) {
        if (date == null) {
            return "";
        }

        return simpleDateFormat.format(date);
    }
}
