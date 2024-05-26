package ru.nsu.kondrenko.gui.controller.options;

import ru.nsu.kondrenko.gui.controller.OptionController;

import java.awt.event.ActionEvent;

public class CreateOrderController extends OptionController {
    public CreateOrderController(String optionName) {
        super(optionName);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        getView().showOrderCreationForm();
    }
}
