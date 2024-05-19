package ru.nsu.kondrenko.model.services.prescription.impl;

import ru.nsu.kondrenko.model.services.ServiceConfig;
import ru.nsu.kondrenko.model.services.prescription.PrescriptionService;

public class PrescriptionServiceImpl implements PrescriptionService {
    private final String address;
    private final int port;

    public PrescriptionServiceImpl(ServiceConfig config) {
        address = config.getAddress();
        port = config.getPort();
    }
}
