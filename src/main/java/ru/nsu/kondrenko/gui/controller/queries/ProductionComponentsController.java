package ru.nsu.kondrenko.gui.controller.queries;

import ru.nsu.kondrenko.gui.controller.QueryController;
import ru.nsu.kondrenko.gui.controller.utils.fillers.Filler;
import ru.nsu.kondrenko.model.services.production.ProductionService;

import java.util.List;

public class ProductionComponentsController extends QueryController {
    private final ProductionService productionService;

    public ProductionComponentsController(Filler filler, String queryName, ProductionService productionService) {
        super(filler, queryName);
        this.productionService = productionService;
    }

    @Override
    protected List<?> getResult() throws Exception {
        return productionService.getProductionComponents();
    }
}
