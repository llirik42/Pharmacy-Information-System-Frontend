package ru.nsu.kondrenko.gui.controller.fillers;

import ru.nsu.kondrenko.model.dto.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderFiller implements Filler {
    private static final String[] COLUMNS = {
            "Номер заказа",
            "Дата регистрации",
            "Назначенная дата получения",
            "Дата получения",
            "Оплачен"
    };

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public void fillTable(JTable table, Object[] objects) {
        final Object[][] data = new Object[objects.length][COLUMNS.length];

        for (int i = 0; i < objects.length; i++) {
            final Order order = (Order) objects[i];
            final Date registrationDatetime = order.getRegistrationDatetime();
            final Date appointedDatetime = order.getAppointedDatetime();
            final Date obtainingDatetime = order.getObtainingDatetime();
            data[i][0] = order.getId();
            data[i][1] = getDateRepresentation(registrationDatetime);
            data[i][2] = getDateRepresentation(appointedDatetime);
            data[i][3] = getDateRepresentation(obtainingDatetime);
            data[i][4] = order.isPaid() ? "+" : "";
        }

        table.setModel(new DefaultTableModel(data, COLUMNS));
    }

    private String getDateRepresentation(Date date) {
        if (date == null) {
            return "";
        }

        return simpleDateFormat.format(date);
    }
}
