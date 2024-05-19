package ru.nsu.kondrenko.model.services.technologies.impl;

import ru.nsu.kondrenko.model.dto.Technology;
import ru.nsu.kondrenko.model.services.technologies.TechnologyService;
import ru.nsu.kondrenko.model.services.technologies.exceptions.TechnologyServiceException;

import java.util.List;

public class TechnologyServiceImpl implements TechnologyService {
    @Override
    public List<Technology> getTechnologies(Integer drugId, Integer drugTypeId, boolean inProduction) throws TechnologyServiceException {
        return List.of();
    }
}
