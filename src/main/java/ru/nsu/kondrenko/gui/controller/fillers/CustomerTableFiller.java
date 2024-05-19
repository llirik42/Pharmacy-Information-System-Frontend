package ru.nsu.kondrenko.gui.controller.fillers;

import ru.nsu.kondrenko.model.dto.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomerTableFiller implements TableFiller {
    private static final String[] COLUMNS = {
            "№",
            "ФИО",
            "Номер телефона",
            "Адрес",
    };

    @Override
    public void fillTable(JTable table, Object[] objects) {
        final Object[][] data = new Object[objects.length][COLUMNS.length];

        for (int i = 0; i < objects.length; i++) {
            final Customer customer = (Customer) objects[i];
            data[i][0] = i + 1;
            data[i][1] = customer.getFullName();
            data[i][2] = customer.getPhoneNumber();
            data[i][3] = customer.getAddress();
        }

        table.setModel(new DefaultTableModel(data, COLUMNS));
    }
}
