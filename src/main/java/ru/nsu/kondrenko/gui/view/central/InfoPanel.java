package ru.nsu.kondrenko.gui.view.central;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    public InfoPanel(int attributesNumber) {
        setBackground(Color.WHITE);
        setLayout(new GridLayout(attributesNumber, 1, 0, 30));
    }
}
