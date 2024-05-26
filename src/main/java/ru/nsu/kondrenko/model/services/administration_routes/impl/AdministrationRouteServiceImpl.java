package ru.nsu.kondrenko.model.services.administration_routes.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.nsu.kondrenko.model.dto.AdministrationRoute;
import ru.nsu.kondrenko.model.services.ServiceConfig;
import ru.nsu.kondrenko.model.services.administration_routes.AdministrationRouteService;
import ru.nsu.kondrenko.model.services.administration_routes.exceptions.AdministrationServiceException;

import java.util.List;

public class AdministrationRouteServiceImpl implements AdministrationRouteService {
    private final String address;
    private final int port;

    public AdministrationRouteServiceImpl(ServiceConfig serviceConfig) {
        address = serviceConfig.getAddress();
        port = serviceConfig.getPort();
    }

    @Override
    public List<AdministrationRoute> getAdministrationRoutes() throws AdministrationServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.exchange(
                    getAdministrationRoutesUrl(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<AdministrationRoute>>() {

                    }
            ).getBody();
        } catch (Exception exception) {
            throw new AdministrationServiceException("Fetching administration routes failed", exception);
        }
    }

    private String getAdministrationRoutesUrl() {
        return String.format("http://%s:%s/administration-routes/", address, port);
    }
}
