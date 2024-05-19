package ru.nsu.kondrenko.model.services.patients.impl;

import ru.nsu.kondrenko.model.dto.Patient;
import ru.nsu.kondrenko.model.services.patients.PatientService;
import ru.nsu.kondrenko.model.services.patients.exceptions.PatientServiceException;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    @Override
    public List<Patient> getPatients() throws PatientServiceException {
        return List.of();
    }
}
