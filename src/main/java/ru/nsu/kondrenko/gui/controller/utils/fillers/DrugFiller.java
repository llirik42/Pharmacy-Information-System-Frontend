package ru.nsu.kondrenko.gui.controller.utils.fillers;

import ru.nsu.kondrenko.model.dto.Drug;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DrugFiller implements Filler {
    private static final String[] COLUMNS = {
            "№",
            "Название",
            "Стоимость",
            "Тип",
            "Срок годности (часы)",
            "Критическая норма",
    };

    @Override
    public void fillTable(JTable table, Object[] objects) {
        final Object[][] data = new Object[objects.length][COLUMNS.length];

        for (int i = 0; i < objects.length; i++) {
            final Drug drug = (Drug) objects[i];
            data[i][0] = i + 1;
            data[i][1] = drug.getName();
            data[i][2] = drug.getCost();
            data[i][3] = drug.getDrugType().getName();
            data[i][4] = drug.getShelfLife();
            data[i][5] = drug.getCriticalAmount();
        }

        table.setModel(new DefaultTableModel(data, COLUMNS));
    }
}
