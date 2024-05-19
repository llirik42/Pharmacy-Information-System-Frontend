package ru.nsu.kondrenko.gui.controller;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.services.drugs.DrugService;
import ru.nsu.kondrenko.model.services.drugs.exceptions.DrugServiceException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@RequiredArgsConstructor
public class DrugsController implements ActionListener {
    private static final String[] COLUMNS = {
            "№",
            "Название",
            "Стоимость",
            "Тип",
            "Срок годности (часы)",
            "Критическая норма",
    };

    private final DrugService drugService;

    @Setter
    private View view;

    @Setter
    private JTable table;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            final List<Drug> drugs = drugService.getDrugs();
            final Object[][] data = new Object[drugs.size()][COLUMNS.length];

            for (int i = 0; i < drugs.size(); i++) {
                final Drug drug = drugs.get(i);
                data[i][0] = i + 1;
                data[i][1] = drug.getName();
                data[i][2] = drug.getCost();
                data[i][3] = drug.getDrugType().getName();
                data[i][4] = drug.getShelfLife();
                data[i][5] = drug.getCriticalAmount();
            }

            table.setModel(new DefaultTableModel(data, COLUMNS));
        } catch (DrugServiceException exception) {
            view.showError(exception.getLocalizedMessage());
        }
    }
}
