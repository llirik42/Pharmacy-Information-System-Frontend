package ru.nsu.kondrenko.gui.controller.queries;

import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.model.services.drugs.DrugService;

import java.util.List;

public class DrugsController extends QueryController {
    private final DrugService drugService;

    public DrugsController(Filler filler, String queryName, DrugService drugService) {
        super(filler, queryName);
        this.drugService = drugService;
    }

    @Override
    protected List<?> getResult() throws Exception {
        return drugService.getDrugs();
    }
}
