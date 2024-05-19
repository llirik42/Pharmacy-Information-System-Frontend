package ru.nsu.kondrenko.model.services.drugs.impl;

import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.dto.StoredDrug;
import ru.nsu.kondrenko.model.dto.UsedDrug;
import ru.nsu.kondrenko.model.services.drugs.DrugService;
import ru.nsu.kondrenko.model.services.drugs.exceptions.DrugServiceException;

import java.util.Date;
import java.util.List;

public class DrugServiceImpl implements DrugService {
    @Override
    public List<Drug> getDrugs() throws DrugServiceException {
        return List.of();
    }

    @Override
    public List<UsedDrug> getPopularDrugs(int limit, Integer drugTypeId) throws DrugServiceException {
        return List.of();
    }

    @Override
    public List<Drug> getCriticalAmountDrugs() throws DrugServiceException {
        return List.of();
    }

    @Override
    public List<StoredDrug> getMinimalAmountDrigs(Integer drugTypeId) throws DrugServiceException {
        return List.of();
    }

    @Override
    public List<UsedDrug> getUsedDrugs(Date periodStart, Date periodEnd) throws DrugServiceException {
        return List.of();
    }
}
