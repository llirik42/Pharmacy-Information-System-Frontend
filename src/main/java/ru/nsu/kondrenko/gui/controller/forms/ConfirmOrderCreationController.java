package ru.nsu.kondrenko.gui.controller.forms;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.view.central.OrderCreationForm;
import ru.nsu.kondrenko.model.dto.*;
import ru.nsu.kondrenko.model.services.customers.CustomerService;
import ru.nsu.kondrenko.model.services.doctors.DoctorService;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.patients.PatientService;
import ru.nsu.kondrenko.model.services.prescription.PrescriptionService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

@RequiredArgsConstructor
public class ConfirmOrderCreationController implements ActionListener {
    private final OrderService orderService;
    private final CustomerService customerService;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final PrescriptionService prescriptionService;

    @Setter
    private OrderCreationForm orderCreationForm;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        final Customer customer = orderCreationForm.getCustomer();
        final Prescription prescription = orderCreationForm.getPrescription();
        final Patient patient = prescription.getPatient();
        final Doctor doctor = prescription.getDoctor();
        final List<PrescriptionItem> items = prescription.getItems();
    }
}
