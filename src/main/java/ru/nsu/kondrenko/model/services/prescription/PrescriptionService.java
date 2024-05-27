package ru.nsu.kondrenko.model.services.prescription;

import ru.nsu.kondrenko.model.services.prescription.exceptions.PrescriptionServiceException;
import ru.nsu.kondrenko.model.services.prescription.requests.PrescriptionCreationRequest;
import ru.nsu.kondrenko.model.services.prescription.responses.PrescriptionCreationResponse;

public interface PrescriptionService {
    PrescriptionCreationResponse createPrescription(PrescriptionCreationRequest request) throws PrescriptionServiceException;
}
