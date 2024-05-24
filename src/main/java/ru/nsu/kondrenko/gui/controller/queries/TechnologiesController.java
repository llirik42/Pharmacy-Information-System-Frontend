package ru.nsu.kondrenko.gui.controller.queries;

import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.model.services.technologies.TechnologyService;

import java.util.List;

public class TechnologiesController extends QueryController {
    private final TechnologyService technologyService;

    public TechnologiesController(Filler filler, String queryName, TechnologyService technologyService) {
        super(filler, queryName);
        this.technologyService = technologyService;
    }

    @Override
    protected List<?> getResult() throws Exception {
        return technologyService.getTechnologies(
                null,
                null,
                false
        );
    }
}
