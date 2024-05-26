package ru.nsu.kondrenko.gui.controller.utils;

import ru.nsu.kondrenko.model.dto.Drug;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DrugComboBox extends JComboBox<String> {
    private List<Drug> drugs;

    private Drug prevSelectedDrug = null;

    public void setDrugList(List<Drug> drugs) {
        this.drugs = new ArrayList<>(drugs);
        this.drugs.sort((d1, d2) -> d1.getName().compareToIgnoreCase(d2.getName()));

        changeModel();
        selectPreviousDrug();
    }

    public Drug getSelectedDrug() {
        final int selectedIndex = getSelectedIndex();
        prevSelectedDrug = selectedIndex == 0 ? null : drugs.get(getDrugIndexByItemIndex(selectedIndex));
        return prevSelectedDrug;
    }

    private void changeModel() {
        final String[] drugNames = new String[drugs.size() + 1];

        drugNames[0] = "";
        for (int i = 0; i < drugs.size(); i++) {
            final Drug drug = this.drugs.get(i);
            final int itemIndex = getItemIndexByDrugIndex(i);
            drugNames[itemIndex] = drug.getName();
        }

        setModel(new DefaultComboBoxModel<>(drugNames));
    }

    private void selectPreviousDrug() {
        if (prevSelectedDrug != null) {
            final int prevSelectedDrugIndex = this.drugs.indexOf(prevSelectedDrug);

            if (prevSelectedDrugIndex != -1) {
                setSelectedIndex(getItemIndexByDrugIndex(prevSelectedDrugIndex));
            }
        }
    }

    private int getItemIndexByDrugIndex(int drugIndex) {
        return drugIndex + 1;
    }

    private int getDrugIndexByItemIndex(int itemIndex) {
        return itemIndex - 1;
    }
}
