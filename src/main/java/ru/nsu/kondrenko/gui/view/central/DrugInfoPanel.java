package ru.nsu.kondrenko.gui.view.central;

import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.dto.DrugType;

import javax.swing.*;

public class DrugInfoPanel extends InfoPanel {
    private final JLabel drugNameLabel;
    private final JLabel drugTypeLabel;
    private final JLabel drugDescriptionLabel;
    private final JLabel drugCostLabel;
    private final JLabel shelfLifeLabel;
    private final JLabel isCookableLabel;

    public DrugInfoPanel() {
        super(6);

        drugNameLabel = Utils.createAttributeValueLabel();
        drugTypeLabel = Utils.createAttributeValueLabel();
        drugDescriptionLabel = Utils.createAttributeValueLabel();
        drugCostLabel = Utils.createAttributeValueLabel();
        shelfLifeLabel = Utils.createAttributeValueLabel();
        isCookableLabel = Utils.createAttributeValueLabel();

        add(Utils.createAttributePanel("Название", drugNameLabel));
        add(Utils.createAttributePanel("Тип", drugTypeLabel));
        add(Utils.createAttributePanel("Описание", drugDescriptionLabel));
        add(Utils.createAttributePanel("Стоимость", drugCostLabel));
        add(Utils.createAttributePanel("Срок хранения", shelfLifeLabel));
        add(Utils.createAttributePanel("Можно изготовить", isCookableLabel));
    }

    public void update(Drug drug) {
        final DrugType drugType = drug.getDrugType();

        drugNameLabel.setText(drug.getName());
        drugTypeLabel.setText(drugType.getName());
        drugDescriptionLabel.setText(drug.getDescription());
        drugCostLabel.setText(Integer.toString(drug.getCost()));
        shelfLifeLabel.setText(getShelfLifeRepresentation(drug.getShelfLife()));
        isCookableLabel.setText(Utils.booleanAttributeToString(drugType.isCookable()));
    }

    private static String getShelfLifeRepresentation(int shelfLife) {
        if (shelfLife < 24) {
            return "%s ч.".formatted(shelfLife);
        }

        final int days = shelfLife / 24;
        final int hours = shelfLife % 24;

        if (hours > 0) {
            return "%s д., %s ч.".formatted(days, hours);
        } else {
            return "%s д.".formatted(days);
        }
    }
}
