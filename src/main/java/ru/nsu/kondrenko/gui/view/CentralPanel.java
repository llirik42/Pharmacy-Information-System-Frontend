package ru.nsu.kondrenko.gui.view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;

@Getter
public class CentralPanel extends JPanel {
    private final JTable table;

    private final JLabel titleLabel;

    public CentralPanel() {
        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        table.setShowGrid(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);

        table.setBackground(Color.WHITE);
        table.setFont(new Font(Constants.FONT_FAMILY, Font.PLAIN, 20));
        table.setRowHeight(50);

        JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());

        titleLabel = new JLabel("", SwingConstants.CENTER);
        titleLabel.setFont(new Font(Constants.FONT_FAMILY, Font.PLAIN, 16));

        add(scrollPane, BorderLayout.CENTER);
        add(titleLabel, BorderLayout.NORTH);
    }
}
