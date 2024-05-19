package ru.nsu.kondrenko.gui.controller.fillers;

import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.dto.ProductionComponent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductionComponentTableFiller implements TableFiller {
    private static final String[] COLUMNS = {
            "№",
            "Название",
            "Требуемое кол-во",
            "Стоимость",
            "Тип",
            "Срок годности (часы)",
            "Критическая норма",
    };

    @Override
    public void fillTable(JTable table, Object[] objects) {
        final Object[][] data = new Object[objects.length][COLUMNS.length];

        for (int i = 0; i < objects.length; i++) {
            final ProductionComponent component = (ProductionComponent) objects[i];
            final Drug drug = component.getComponent();
            data[i][0] = i + 1;
            data[i][1] = drug.getName();
            data[i][2] = component.getComponentAmount();
            data[i][3] = drug.getCost();
            data[i][4] = drug.getDrugType().getName();
            data[i][5] = drug.getShelfLife();
            data[i][6] = drug.getCriticalAmount();
        }

        table.setModel(new DefaultTableModel(data, COLUMNS));
    }
}
