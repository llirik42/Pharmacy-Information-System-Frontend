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

    public static JPanel create2ComponentPanel(Component c1, Component c2) {
        final JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        result.add(c1, BorderLayout.WEST);
        result.add(c2, BorderLayout.CENTER);
        result.setBackground(new Color(230, 230, 230));
        return result;
    }

    public static JPanel create3ComponentPanel(Component c1, Component c2, Component c3) {
        final JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        result.add(c1, BorderLayout.WEST);
        result.add(c2, BorderLayout.CENTER);
        result.add(c3, BorderLayout.EAST);
        result.setBackground(new Color(230, 230, 230));
        return result;
    }

    public static JPanel createAttributePanel(String attributeTitle, Component attributeValueComponent) {
        return create2ComponentPanel(createAttributeTitleLabel(attributeTitle), attributeValueComponent);
    }

    public static String booleanAttributeToString(boolean value) {
        return value ? "Да" : "Нет";
    }

    public static String customerToString(Customer customer) {
        if (customer == null) {
            return "";
        }

        return "%s, %s, %s".formatted(
                customer.getFullName(),
                customer.getPhoneNumber(),
                customer.getAddress()
        );
    }
}
