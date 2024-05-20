package ru.nsu.kondrenko.gui.view;

import javax.swing.*;
import java.awt.*;

public class Utils {
    public static void addComponentToPanel(JPanel panel, String title, Component component) {
        panel.add(new JLabel(title + " ".repeat(8)));
        panel.add(component);
    }
}
