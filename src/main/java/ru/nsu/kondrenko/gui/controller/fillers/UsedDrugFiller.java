package ru.nsu.kondrenko.gui.controller.fillers;

import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.dto.UsedDrug;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UsedDrugFiller implements Filler {
    private static final String[] COLUMNS = {
            "№",
            "Название",
            "Использованное кол-во",
            "Стоимость",
            "Тип",
            "Срок годности (часы)",
            "Критическая норма",
    };

    @Override
    public void fillTable(JTable table, Object[] objects) {
        final Object[][] data = new Object[objects.length][COLUMNS.length];

        for (int i = 0; i < objects.length; i++) {
            final UsedDrug usedDrug = (UsedDrug) objects[i];
            final Drug drug = usedDrug.getDrug();
            data[i][0] = i + 1;
            data[i][1] = drug.getName();
            data[i][2] = usedDrug.getUseNumber();
            data[i][3] = drug.getCost();
            data[i][4] = drug.getDrugType().getName();
            data[i][5] = drug.getShelfLife();
            data[i][6] = drug.getCriticalAmount();
        }

        table.setModel(new DefaultTableModel(data, COLUMNS));
    }
}
