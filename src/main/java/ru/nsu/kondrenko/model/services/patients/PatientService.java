package ru.nsu.kondrenko.model.services.patients;

import ru.nsu.kondrenko.model.dto.Patient;
import ru.nsu.kondrenko.model.services.patients.exceptions.PatientServiceException;

import java.util.List;

public interface PatientService {
    List<Patient> getPatients() throws PatientServiceException;
}
