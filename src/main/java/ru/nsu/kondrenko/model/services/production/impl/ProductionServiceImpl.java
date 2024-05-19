package ru.nsu.kondrenko.model.services.production.impl;

import ru.nsu.kondrenko.model.dto.ProductionComponent;
import ru.nsu.kondrenko.model.services.production.ProductionService;
import ru.nsu.kondrenko.model.services.production.exceptions.ProductionServiceException;

import java.util.List;

public class ProductionServiceImpl implements ProductionService {
    @Override
    public List<ProductionComponent> getProductionComponents() throws ProductionServiceException {
        return List.of();
    }
}
