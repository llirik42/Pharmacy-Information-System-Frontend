package ru.nsu.kondrenko.model.services.administration_routes;

import ru.nsu.kondrenko.model.dto.AdministrationRoute;
import ru.nsu.kondrenko.model.services.administration_routes.exceptions.AdministrationServiceException;

import java.util.List;

public interface AdministrationRouteService {
    List<AdministrationRoute> getAdministrationRoutes() throws AdministrationServiceException;
}
