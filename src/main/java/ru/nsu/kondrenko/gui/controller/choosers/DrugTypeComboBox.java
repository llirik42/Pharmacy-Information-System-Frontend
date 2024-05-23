package ru.nsu.kondrenko.gui.controller.choosers;

import ru.nsu.kondrenko.model.dto.DrugType;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DrugTypeComboBox extends JComboBox<String> {
    private List<DrugType> drugTypes;

    private DrugType prevSelectedDrugType = null;

    public void setDrugTypeList(List<DrugType> drugTypes) {
        this.drugTypes = new ArrayList<>(drugTypes);
        this.drugTypes.sort((d1, d2) -> d1.getName().compareToIgnoreCase(d2.getName()));

        changeModel();
        selectPreviousDrugType();
    }

    public DrugType getSelectedDrugType() {
        final int selectedIndex = getSelectedIndex();
        prevSelectedDrugType = selectedIndex == 0 ? null : drugTypes.get(getDrugTypeIndexByItemIndex(selectedIndex));
        return prevSelectedDrugType;
    }

    private void changeModel() {
        final String[] drugTypeNames = new String[drugTypes.size() + 1];

        drugTypeNames[0] = "";
        for (int i = 0; i < drugTypes.size(); i++) {
            final DrugType drugType = this.drugTypes.get(i);
            final int itemIndex = getItemIndexByDrugTypeIndex(i);
            drugTypeNames[itemIndex] = drugType.getName();
        }

        setModel(new DefaultComboBoxModel<>(drugTypeNames));
    }

    private void selectPreviousDrugType() {
        if (prevSelectedDrugType != null) {
            final int prevSelectedDrugTypeIndex = this.drugTypes.indexOf(prevSelectedDrugType);

            if (prevSelectedDrugTypeIndex != -1) {
                setSelectedIndex(getItemIndexByDrugTypeIndex(prevSelectedDrugTypeIndex));
            }
        }
    }

    private int getItemIndexByDrugTypeIndex(int drugIndex) {
        return drugIndex + 1;
    }

    private int getDrugTypeIndexByItemIndex(int itemIndex) {
        return itemIndex - 1;
    }
}
