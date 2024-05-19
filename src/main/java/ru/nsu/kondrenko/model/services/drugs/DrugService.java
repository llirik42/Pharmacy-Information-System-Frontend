package ru.nsu.kondrenko.model.services.drugs;

import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.dto.StoredDrug;
import ru.nsu.kondrenko.model.dto.UsedDrug;
import ru.nsu.kondrenko.model.services.drugs.exceptions.DrugServiceException;

import java.util.Date;
import java.util.List;

public interface DrugService {
    List<Drug> getDrugs() throws DrugServiceException;

    List<UsedDrug> getPopularDrugs(int limit, Integer drugTypeId) throws DrugServiceException;

    List<Drug> getCriticalAmountDrugs() throws DrugServiceException;

    List<StoredDrug> getMinimalAmountDrigs(Integer drugTypeId) throws DrugServiceException;

    List<UsedDrug> getUsedDrugs(Date periodStart, Date periodEnd) throws DrugServiceException;
}
