package ru.nsu.kondrenko.gui.view;

import ru.nsu.kondrenko.gui.controller.OptionController;
import ru.nsu.kondrenko.gui.controller.QueryController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OptionsPanel extends JPanel {
    public OptionsPanel(List<OptionController> optionControllers, List<QueryController> queryControllers) {
        setPreferredSize(new Dimension(350, -1));

        for (final var it : optionControllers) {
            add(new Option(it.getOptionName(), it));
        }

        for (final var it : queryControllers) {
            add(new Option(it.getOptionName(), it));
        }
    }
}
