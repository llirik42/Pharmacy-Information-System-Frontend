package ru.nsu.kondrenko.gui.view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;

@Getter
public class CentralPanel extends JPanel {
    private final JTable table;

    public CentralPanel() {

        String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

        Object[][] data = {
                {"Kathy", "SMITH",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };



        table = new JTable(data, columnNames);
        table.setDefaultEditor(Object.class, null);
        table.setShowGrid(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);



        table.setBackground(Color.WHITE);
        table.setFont(new Font(Constaints.FONT_FAMILY, Font.PLAIN, 20));
        table.setRowHeight(50);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        add(scrollPane);
    }
}
