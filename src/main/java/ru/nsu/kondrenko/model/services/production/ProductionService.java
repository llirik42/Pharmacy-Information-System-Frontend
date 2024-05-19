package ru.nsu.kondrenko.model.services.production;

import ru.nsu.kondrenko.model.dto.ProductionComponent;
import ru.nsu.kondrenko.model.services.production.exceptions.ProductionServiceException;

import java.util.List;

public interface ProductionService {
    List<ProductionComponent> getProductionComponents() throws ProductionServiceException;
}
