package ru.nsu.kondrenko.gui.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Option extends JButton {
    public Option(String label, ActionListener actionListener) {
        super(label);
        setPreferredSize(new Dimension(350, 50));
        setFont(new Font(Constaints.FONT_FAMILY, Font.PLAIN, 12));
        addActionListener(actionListener);
    }
}
