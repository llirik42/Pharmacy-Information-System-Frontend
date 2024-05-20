package ru.nsu.kondrenko.gui.controller.choosers;

import ru.nsu.kondrenko.model.dto.Drug;

import javax.swing.*;

public class DrugComboBox extends JComboBox<String> {
    public void setDrugList() {
        setModel(new DefaultComboBoxModel<>(new String[]{"a", "b", "c", "d"}));
    }

    public Drug getSelectedDrug() {
        return new Drug();
    }
}
