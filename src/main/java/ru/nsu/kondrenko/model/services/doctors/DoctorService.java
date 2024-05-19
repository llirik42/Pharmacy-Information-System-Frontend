package ru.nsu.kondrenko.model.services.doctors;

import ru.nsu.kondrenko.model.dto.Doctor;
import ru.nsu.kondrenko.model.services.doctors.exceptions.DoctorServiceException;

import java.util.List;

public interface DoctorService {
    List<Doctor> getDoctors() throws DoctorServiceException;
}
