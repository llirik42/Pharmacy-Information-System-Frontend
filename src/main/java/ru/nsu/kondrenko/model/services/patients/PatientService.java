package ru.nsu.kondrenko.model.services.patients;

import ru.nsu.kondrenko.model.dto.Patient;
import ru.nsu.kondrenko.model.services.patients.exceptions.PatientServiceException;
import ru.nsu.kondrenko.model.services.patients.requests.PatientCreationRequest;
import ru.nsu.kondrenko.model.services.patients.responses.PatientCreationResponse;

import java.util.List;

public interface PatientService {
    List<Patient> getPatients() throws PatientServiceException;

    PatientCreationResponse createPatient(PatientCreationRequest request) throws PatientServiceException;
}
