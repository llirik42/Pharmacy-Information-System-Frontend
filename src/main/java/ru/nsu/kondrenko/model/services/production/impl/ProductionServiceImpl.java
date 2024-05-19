package ru.nsu.kondrenko.model.services.production.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.nsu.kondrenko.model.dto.ProductionComponent;
import ru.nsu.kondrenko.model.services.ServiceConfig;
import ru.nsu.kondrenko.model.services.production.ProductionService;
import ru.nsu.kondrenko.model.services.production.exceptions.ProductionServiceException;

import java.util.List;

public class ProductionServiceImpl implements ProductionService {
    private final String address;
    private final int port;

    public ProductionServiceImpl(ServiceConfig config) {
        address = config.getAddress();
        port = config.getPort();
    }

    @Override
    public List<ProductionComponent> getProductionComponents() throws ProductionServiceException {
        return fetchProductionComponents(
                getProductionComponentsUrl(),
                "Fetching production components failed"
        );
    }

    private List<ProductionComponent> fetchProductionComponents(String url, String errorMessage) throws ProductionServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ProductionComponent>>() {

                    }
            ).getBody();
        } catch (Exception exception) {
            throw new ProductionServiceException(errorMessage, exception);
        }
    }

    private String getProductionComponentsUrl() {
        return String.format("http://%s:%s/production/components/", address, port);
    }
}
