package ru.nsu.kondrenko.gui.view;

import ru.nsu.kondrenko.gui.controller.OptionController;
import ru.nsu.kondrenko.gui.controller.QueryController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends Window {
    public MainWindow(List<OptionController> optionControllers, List<QueryController> queryControllers) {
        final JPanel optionsPanel = new OptionsPanel(optionControllers, queryControllers);

        add(optionsPanel, BorderLayout.WEST);

        final CentralPanel centralPanel = new CentralPanel();
        add(centralPanel, BorderLayout.CENTER);

        final JTable table = centralPanel.getTable();
        final JLabel queryNameLabel = centralPanel.getTitleLabel();

        for (final var it : optionControllers) {
            it.setTitleLabel(queryNameLabel);
        }

        for (final var it : queryControllers) {
            it.setTable(table);
            it.setTitleLabel(queryNameLabel);
        }

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        pack();
    }
}
