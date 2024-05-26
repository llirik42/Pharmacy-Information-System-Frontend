package ru.nsu.kondrenko.gui.view.central;

import ru.nsu.kondrenko.model.dto.Drug;

import javax.swing.*;
import java.awt.*;

public class DrugInfoPanel extends JPanel {
    private final JLabel drugNameLabel;

    private final JLabel drugCostLabel;

    private final JLabel drugDescriptionLabel;

    public DrugInfoPanel() {
        setBackground(Color.WHITE);
        setLayout(new GridLayout(3, 2));

        drugNameLabel = new JLabel();
        drugCostLabel = new JLabel();
        drugDescriptionLabel = new JLabel();

        add(new JLabel("Название"));
        add(drugNameLabel);

        add(new JLabel("Стоимость" + " ".repeat(8)));
        add(drugCostLabel);

        add(new JLabel("Описание" + " ".repeat(8)));
        add(drugDescriptionLabel);
    }

    public void update(Drug drug) {
        drugNameLabel.setText(drug.getName());
        drugCostLabel.setText(Integer.toString(drug.getCost()));
        drugDescriptionLabel.setText(drug.getDescription());
    }
}
