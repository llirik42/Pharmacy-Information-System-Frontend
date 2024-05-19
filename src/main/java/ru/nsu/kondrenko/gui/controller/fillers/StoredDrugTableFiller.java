package ru.nsu.kondrenko.gui.controller.fillers;

import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.dto.StoredDrug;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StoredDrugTableFiller implements TableFiller {
    private static final String[] COLUMNS = {
            "№",
            "Название",
            "Кол-во на складе",
            "Стоимость",
            "Тип",
            "Срок годности (часы)",
            "Критическая норма",
    };

    @Override
    public void fillTable(JTable table, Object[] objects) {
        final Object[][] data = new Object[objects.length][COLUMNS.length];

        for (int i = 0; i < objects.length; i++) {
            final StoredDrug storedDrug = (StoredDrug) objects[i];
            final Drug drug = storedDrug.getDrug();
            data[i][0] = i + 1;
            data[i][1] = drug.getName();
            data[i][2] = storedDrug.getStoredNumber();
            data[i][3] = drug.getCost();
            data[i][4] = drug.getDrugType().getName();
            data[i][5] = drug.getShelfLife();
            data[i][6] = drug.getCriticalAmount();
        }

        table.setModel(new DefaultTableModel(data, COLUMNS));
    }
}
