package ru.nsu.kondrenko.gui.view.west;

import ru.nsu.kondrenko.gui.view.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OptionButton extends JButton {
    public OptionButton(String label, ActionListener actionListener) {
        super(label);
        setPreferredSize(new Dimension(350, 50));
        setFont(new Font(Constants.FONT_FAMILY, Font.PLAIN, 12));
        addActionListener(actionListener);
    }
}
