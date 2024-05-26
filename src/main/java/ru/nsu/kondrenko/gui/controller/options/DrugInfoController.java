package ru.nsu.kondrenko.gui.controller.options;

import ru.nsu.kondrenko.gui.controller.OptionController;
import ru.nsu.kondrenko.model.services.drugs.DrugService;

public class DrugInfoController extends OptionController {
    private final DrugService drugService;

    public DrugInfoController(String optionName, DrugService drugService) {
        super(optionName);

        this.drugService = drugService;
    }
}
