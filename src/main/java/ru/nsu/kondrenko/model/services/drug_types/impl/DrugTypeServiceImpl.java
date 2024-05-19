package ru.nsu.kondrenko.model.services.drug_types.impl;

import ru.nsu.kondrenko.model.dto.DrugType;
import ru.nsu.kondrenko.model.services.drug_types.DrugTypeService;
import ru.nsu.kondrenko.model.services.drug_types.exceptions.DrugTypeServiceException;

import java.util.List;

public class DrugTypeServiceImpl implements DrugTypeService {
    @Override
    public List<DrugType> getDrugTypes() throws DrugTypeServiceException {
        return List.of();
    }

    @Override
    public List<DrugType> getCriticalAmountDrugTypes() throws DrugTypeServiceException {
        return List.of();
    }
}
