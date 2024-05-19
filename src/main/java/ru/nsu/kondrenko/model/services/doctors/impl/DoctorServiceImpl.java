package ru.nsu.kondrenko.model.services.doctors.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.nsu.kondrenko.model.dto.Doctor;
import ru.nsu.kondrenko.model.services.ServiceConfig;
import ru.nsu.kondrenko.model.services.doctors.DoctorService;
import ru.nsu.kondrenko.model.services.doctors.exceptions.DoctorServiceException;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    private final String address;
    private final int port;

    public DoctorServiceImpl(ServiceConfig config) {
        this.address = config.getAddress();
        this.port = config.getPort();
    }

    @Override
    public List<Doctor> getDoctors() throws DoctorServiceException {
        return fetchDoctors(
                getDoctorsUrl(),
                "Fetching doctors failed"
        );
    }

    private List<Doctor> fetchDoctors(String url, String errorMessage) throws DoctorServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Doctor>>() {

                    }
            ).getBody();
        } catch (Exception exception) {
            throw new DoctorServiceException(errorMessage, exception);
        }
    }


    private String getDoctorsUrl() {
        return String.format("http://%s:%s/doctors/", address, port);
    }
}
