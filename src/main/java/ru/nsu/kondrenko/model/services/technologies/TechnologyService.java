package ru.nsu.kondrenko.model.services.technologies;

import ru.nsu.kondrenko.model.dto.Technology;
import ru.nsu.kondrenko.model.services.technologies.exceptions.TechnologyServiceException;

import java.util.List;

public interface TechnologyService {
    List<Technology> getTechnologies(Integer drugId, Integer drugTypeId, boolean inProduction) throws TechnologyServiceException;
}
