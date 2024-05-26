package ru.nsu.kondrenko.gui.controller.utils.input;

import ru.nsu.kondrenko.model.dto.Drug;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DrugComboBox extends JComboBox<String> {
    private boolean allowEmpty;

    private List<Drug> drugs;

    private Drug prevSelectedDrug = null;

    public DrugComboBox(boolean allowEmpty) {
        this.allowEmpty = allowEmpty;
    }

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
        setModel(new DefaultComboBoxModel<>(getDrugNames()));
    }

    private String[] getDrugNames() {
        final int size = drugs.size();
        final int drugNamesCount = allowEmpty ? size + 1 : size;

        final String[] drugNames = new String[drugNamesCount];

        if (allowEmpty) {
            drugNames[0] = "";
        }

        for (int i = 0; i < drugs.size(); i++) {
            final Drug drug = this.drugs.get(i);
            final int itemIndex = getItemIndexByDrugIndex(i);
            drugNames[itemIndex] = drug.getName();
        }

        return drugNames;
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
        return allowEmpty ? drugIndex + 1 : drugIndex;
    }

    private int getDrugIndexByItemIndex(int itemIndex) {
        return allowEmpty ? itemIndex - 1 : itemIndex;
    }
}
