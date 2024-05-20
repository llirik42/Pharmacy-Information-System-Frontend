package ru.nsu.kondrenko.gui.view;

import javax.swing.*;
import java.awt.*;

public class Utils {
    public static JPanel createDialogPanel(int componentCount) {
        final JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(new GridLayout(componentCount, 2));
        return dialogPanel;
    }

    public static void addComponentToPanel(JPanel panel, String title, Component component) {
        panel.add(new JLabel(title + " ".repeat(8)));
        panel.add(component);
    }
}
