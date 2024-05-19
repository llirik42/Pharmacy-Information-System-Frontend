package ru.nsu.kondrenko.gui.view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;

@Getter
public class CentralPanel extends JPanel {
    private final JTable table;

    public CentralPanel() {
        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        table.setShowGrid(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);

        table.setBackground(Color.WHITE);
        table.setFont(new Font(Constaints.FONT_FAMILY, Font.PLAIN, 20));
        table.setRowHeight(50);

        JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());

        add(scrollPane, BorderLayout.CENTER);
    }
}
