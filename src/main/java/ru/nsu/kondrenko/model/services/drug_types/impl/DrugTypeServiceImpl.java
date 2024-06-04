package ru.nsu.kondrenko.model.services.drug_types.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.nsu.kondrenko.model.dto.DrugType;
import ru.nsu.kondrenko.model.services.ServiceConfig;
import ru.nsu.kondrenko.model.services.drug_types.DrugTypeService;
import ru.nsu.kondrenko.model.services.drug_types.exceptions.DrugTypeServiceException;

import java.util.List;

public class DrugTypeServiceImpl implements DrugTypeService {
    private final String address;
    private final int port;

    public DrugTypeServiceImpl(ServiceConfig config) {
        address = config.getAddress();
        port = config.getPort();
    }

    @Override
    public List<DrugType> getDrugTypes() throws DrugTypeServiceException {
        return fetchDrugTypes(
                getDrugTypesUrl(),
                "Fetching drug types failed"
        );
    }

    private List<DrugType> fetchDrugTypes(String url, String errorMessage) throws DrugTypeServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<DrugType>>() {

                    }
            ).getBody();
        } catch (Exception exception) {
            throw new DrugTypeServiceException(errorMessage, exception);
        }
    }

    private String getDrugTypesUrl() {
        return String.format("http://%s:%s/drug-types/", address, port);
    }
}
