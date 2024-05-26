package ru.nsu.kondrenko.gui.controller.utils.fillers;

import ru.nsu.kondrenko.model.dto.Customer;
import ru.nsu.kondrenko.model.dto.FrequentCustomer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrequentCustomerFiller implements Filler {
    private static final String[] COLUMNS = {
            "№",
            "ФИО",
            "Кол-во заказов",
            "Номер телефона",
            "Адрес",
    };

    @Override
    public void fillTable(JTable table, Object[] objects) {
        final Object[][] data = new Object[objects.length][COLUMNS.length];

        for (int i = 0; i < objects.length; i++) {
            final FrequentCustomer frequentCustomer = (FrequentCustomer) objects[i];
            final Customer customer = frequentCustomer.getCustomer();
            data[i][0] = i + 1;
            data[i][1] = customer.getFullName();
            data[i][2] = frequentCustomer.getOrderCount();
            data[i][3] = customer.getPhoneNumber();
            data[i][4] = customer.getAddress();
        }

        table.setModel(new DefaultTableModel(data, COLUMNS));
    }
}
