package ru.nsu.kondrenko.model.services.patients.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.nsu.kondrenko.model.dto.Patient;
import ru.nsu.kondrenko.model.services.ServiceConfig;
import ru.nsu.kondrenko.model.services.patients.PatientService;
import ru.nsu.kondrenko.model.services.patients.exceptions.PatientServiceException;
import ru.nsu.kondrenko.model.services.patients.requests.PatientCreationRequest;
import ru.nsu.kondrenko.model.services.patients.responses.PatientCreationResponse;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    private final String address;
    private final int port;

    public PatientServiceImpl(ServiceConfig config) {
        address = config.getAddress();
        port = config.getPort();
    }

    @Override
    public List<Patient> getPatients() throws PatientServiceException {
        return fetchPatients(
                getPatientsUrl(),
                "Fetching patients failed"
        );
    }

    @Override
    public PatientCreationResponse createPatient(PatientCreationRequest request) throws PatientServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.postForEntity(
                    getPatientsUrl(),
                    request,
                    PatientCreationResponse.class
            ).getBody();
        } catch (Exception exception) {
            throw new PatientServiceException("Creation of patient %s failed".formatted(request), exception);
        }
    }

    private List<Patient> fetchPatients(String url, String errorMessage) throws PatientServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Patient>>() {

                    }
            ).getBody();
        } catch (Exception exception) {
            throw new PatientServiceException(errorMessage, exception);
        }
    }

    private String getPatientsUrl() {
        return String.format("http://%s:%s/patients/", address, port);
    }
}
