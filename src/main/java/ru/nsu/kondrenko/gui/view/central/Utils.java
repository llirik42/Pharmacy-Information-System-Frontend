package ru.nsu.kondrenko.gui.view.central;

import ru.nsu.kondrenko.gui.view.Constants;
import ru.nsu.kondrenko.model.dto.Customer;

import javax.swing.*;
import java.awt.*;

public final class Utils {
    public static JLabel createAttributeValueLabel() {
        final JLabel label = new JLabel();
        label.setFont(new Font(Constants.FONT_FAMILY, Font.PLAIN, 18));
        return label;
    }

    public static JLabel createAttributeTitleLabel(String attributeTitle) {
        final JLabel attributeTitleLabel = new JLabel(attributeTitle);
        attributeTitleLabel.setFont(new Font(Constants.FONT_FAMILY, Font.BOLD, 20));
        attributeTitleLabel.setPreferredSize(new Dimension(400, -1));
        return attributeTitleLabel;
    }

    public static JPanel createAttributePanel(String attributeTitle, JLabel attributeValueLabel) {
        final JPanel result = new JPanel();
        result.setLayout(new BorderLayout());

        final JLabel attributeTitleLabel = createAttributeTitleLabel(attributeTitle);
        result.add(attributeTitleLabel, BorderLayout.WEST);
        result.add(attributeValueLabel, BorderLayout.CENTER);
        result.setBackground(new Color(230, 230, 230));

        return result;
    }

    public static String booleanAttributeToString(boolean value) {
        return value ? "Да" : "Нет";
    }

    public static String customerToString(Customer customer) {
        return "%s, %s, %s".formatted(
                customer.getFullName(),
                customer.getPhoneNumber(),
                customer.getAddress()
        );
    }
}
