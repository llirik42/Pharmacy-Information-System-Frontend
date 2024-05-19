package ru.nsu.kondrenko.model.services.technologies.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.nsu.kondrenko.model.dto.Technology;
import ru.nsu.kondrenko.model.services.ServiceConfig;
import ru.nsu.kondrenko.model.services.technologies.TechnologyService;
import ru.nsu.kondrenko.model.services.technologies.exceptions.TechnologyServiceException;

import java.util.List;

public class TechnologyServiceImpl implements TechnologyService {
    private final String address;
    private final int port;

    public TechnologyServiceImpl(ServiceConfig config) {
        address = config.getAddress();
        port = config.getPort();
    }

    @Override
    public List<Technology> getTechnologies(Integer drugId, Integer drugTypeId, boolean inProduction) throws TechnologyServiceException {
        return fetchTechnologies(
                getTechnologiesUrl(drugId, drugTypeId, inProduction),
                "Fetching technologies failed"
        );
    }

    private List<Technology> fetchTechnologies(String url, String errorMessage) throws TechnologyServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Technology>>() {

                    }
            ).getBody();
        } catch (Exception exception) {
            throw new TechnologyServiceException(errorMessage, exception);
        }
    }

    private String getTechnologiesUrl(Integer drugId, Integer drugTypeId, boolean inProduction) {
        String url = String.format("http://%s:%s/technologies?in_production=%s", address, port, inProduction);

        if (drugId != null) {
            url = String.format("%s&drug_id=%s", url, drugId);
        }

        if (drugTypeId != null) {
            url = String.format("%s&drug_type_id=%s", url, drugTypeId);
        }

        return url;
    }
}
