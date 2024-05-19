package ru.nsu.kondrenko.gui.controller.fillers;

import ru.nsu.kondrenko.model.dto.Technology;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TechnologyTableFiller implements TableFiller {
    private static final String[] COLUMNS = {
            "№",
            "Лекарство",
            "Время приготовления",
            "Количество"
    };

    @Override
    public void fillTable(JTable table, Object[] objects) {
        final Object[][] data = new Object[objects.length][COLUMNS.length];

        for (int i = 0; i < objects.length; i++) {
            final Technology technology = (Technology) objects[i];
            data[i][0] = i + 1;
            data[i][1] = technology.getDrug().getName();
            data[i][2] = technology.getCookingTime();
            data[i][3] = technology.getAmount();
        }

        table.setModel(new DefaultTableModel(data, COLUMNS));
    }
}
