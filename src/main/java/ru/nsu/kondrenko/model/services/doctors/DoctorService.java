package ru.nsu.kondrenko.model.services.doctors;

import ru.nsu.kondrenko.model.dto.Doctor;
import ru.nsu.kondrenko.model.services.doctors.exceptions.DoctorServiceException;
import ru.nsu.kondrenko.model.services.doctors.requests.DoctorCreationRequest;
import ru.nsu.kondrenko.model.services.doctors.responses.DoctorCreationResponse;

import java.util.List;

public interface DoctorService {
    List<Doctor> getDoctors() throws DoctorServiceException;

    DoctorCreationResponse createDoctor(DoctorCreationRequest request) throws DoctorServiceException;
}
