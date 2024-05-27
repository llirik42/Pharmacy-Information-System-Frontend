package ru.nsu.kondrenko.model.services.prescription.impl;

import org.springframework.web.client.RestTemplate;
import ru.nsu.kondrenko.model.services.ServiceConfig;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;
import ru.nsu.kondrenko.model.services.orders.response.OrderSearchResponse;
import ru.nsu.kondrenko.model.services.prescription.PrescriptionService;
import ru.nsu.kondrenko.model.services.prescription.exceptions.PrescriptionServiceException;
import ru.nsu.kondrenko.model.services.prescription.requests.PrescriptionCreationRequest;
import ru.nsu.kondrenko.model.services.prescription.responses.PrescriptionCreationResponse;

public class PrescriptionServiceImpl implements PrescriptionService {
    private final String address;
    private final int port;

    public PrescriptionServiceImpl(ServiceConfig config) {
        address = config.getAddress();
        port = config.getPort();
    }

    @Override
    public PrescriptionCreationResponse createPrescription(PrescriptionCreationRequest request) throws PrescriptionServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.postForEntity(
                    getPrescriptionsUrl(),
                    request,
                    PrescriptionCreationResponse.class
            ).getBody();
        } catch (Exception exception) {
            throw new PrescriptionServiceException("Creation of prescription %s failed".formatted(request), exception);
        }
    }

    private String getPrescriptionsUrl() {
        return String.format("http://%s:%s/prescriptions/", address, port);
    }
}
