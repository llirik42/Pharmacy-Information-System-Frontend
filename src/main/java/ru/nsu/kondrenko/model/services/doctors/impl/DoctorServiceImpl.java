package ru.nsu.kondrenko.model.services.doctors.impl;

import ru.nsu.kondrenko.model.dto.Doctor;
import ru.nsu.kondrenko.model.services.doctors.DoctorService;
import ru.nsu.kondrenko.model.services.doctors.exceptions.DoctorServiceException;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    @Override
    public List<Doctor> getDoctors() throws DoctorServiceException {
        return List.of();
    }
}
