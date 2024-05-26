package ru.nsu.kondrenko.gui.view.central;

import ru.nsu.kondrenko.gui.view.Constants;
import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.dto.DrugType;

import javax.swing.*;
import java.awt.*;

public class DrugInfoPanel extends JPanel {
    private final JLabel drugNameLabel;
    private final JLabel drugTypeLabel;
    private final JLabel drugDescriptionLabel;
    private final JLabel drugCostLabel;
    private final JLabel shelfLifeLabel;
    private final JLabel isCookableLabel;

    public DrugInfoPanel() {
        setBackground(Color.WHITE);
        setLayout(new GridLayout(6, 1, 0, 30));

        drugNameLabel = createAttributeValueLabel();
        drugTypeLabel = createAttributeValueLabel();
        drugDescriptionLabel = createAttributeValueLabel();
        drugCostLabel = createAttributeValueLabel();
        shelfLifeLabel = createAttributeValueLabel();
        isCookableLabel = createAttributeValueLabel();

        add(createAttributePanel("Название", drugNameLabel));
        add(createAttributePanel("Тип", drugTypeLabel));
        add(createAttributePanel("Описание", drugDescriptionLabel));
        add(createAttributePanel("Стоимость", drugCostLabel));
        add(createAttributePanel("Срок хранения", shelfLifeLabel));
        add(createAttributePanel("Можно изготовить", isCookableLabel));
    }

    public void update(Drug drug) {
        final DrugType drugType = drug.getDrugType();

        drugNameLabel.setText(drug.getName());
        drugTypeLabel.setText(drugType.getName());
        drugDescriptionLabel.setText(drug.getDescription());
        drugCostLabel.setText(Integer.toString(drug.getCost()));
        shelfLifeLabel.setText(getShelfLifeRepresentation(drug.getShelfLife()));
        isCookableLabel.setText(drugType.isCookable() ? "Да" : "Нет");
    }

    private static JLabel createAttributeValueLabel() {
        final JLabel label = new JLabel();
        label.setFont(new Font(Constants.FONT_FAMILY, Font.PLAIN, 18));
        return label;
    }

    private static JLabel createAttributeTitleLabel(String attributeTitle) {
        final JLabel attributeTitleLabel = new JLabel(attributeTitle);
        attributeTitleLabel.setFont(new Font(Constants.FONT_FAMILY, Font.BOLD, 20));
        attributeTitleLabel.setPreferredSize(new Dimension(300, -1));
        return attributeTitleLabel;
    }

    private static JPanel createAttributePanel(String attributeTitle, JLabel attributeValueLabel) {
        final JPanel result = new JPanel();
        result.setLayout(new BorderLayout());

        final JLabel attributeTitleLabel = createAttributeTitleLabel(attributeTitle);
        result.add(attributeTitleLabel, BorderLayout.WEST);
        result.add(attributeValueLabel, BorderLayout.CENTER);
        result.setBackground(new Color(230, 230, 230));

        return result;
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
