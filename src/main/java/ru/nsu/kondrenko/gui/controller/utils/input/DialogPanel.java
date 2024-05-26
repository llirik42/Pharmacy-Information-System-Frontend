package ru.nsu.kondrenko.gui.controller.utils.input;

import javax.swing.*;
import java.awt.*;

public class DialogPanel extends JPanel {
    public DialogPanel(int componentCount) {
        super();
        setLayout(new GridLayout(componentCount, 2));
    }

    public void addComponent(String componentTitle, Component component) {
        add(new JLabel(componentTitle + " ".repeat(8)));
        add(component);
    }
}
