package ru.nsu.kondrenko.model.services.drug_types;

import ru.nsu.kondrenko.model.dto.DrugType;
import ru.nsu.kondrenko.model.services.drug_types.exceptions.DrugTypeServiceException;

import java.util.List;

public interface DrugTypeService {
    List<DrugType> getDrugTypes() throws DrugTypeServiceException;
}
