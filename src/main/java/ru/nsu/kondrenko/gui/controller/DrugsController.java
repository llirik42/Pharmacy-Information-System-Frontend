package ru.nsu.kondrenko.gui.controller;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.model.services.drugs.DrugService;

import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@RequiredArgsConstructor
public class DrugsController implements ActionListener {
    private final DrugService drugService;

    @Setter
    private TableModel tableModel;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
