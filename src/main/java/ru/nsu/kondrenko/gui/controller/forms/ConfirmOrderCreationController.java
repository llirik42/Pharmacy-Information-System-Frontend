package ru.nsu.kondrenko.gui.controller.forms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.View;
import ru.nsu.kondrenko.gui.view.central.OrderCreationForm;
import ru.nsu.kondrenko.model.dto.*;
import ru.nsu.kondrenko.model.services.customers.CustomerService;
import ru.nsu.kondrenko.model.services.customers.requests.CustomerCreationRequest;
import ru.nsu.kondrenko.model.services.customers.responses.CustomerCreationResponse;
import ru.nsu.kondrenko.model.services.customers.responses.CustomerCreationStatus;
import ru.nsu.kondrenko.model.services.doctors.DoctorService;
import ru.nsu.kondrenko.model.services.doctors.requests.DoctorCreationRequest;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.orders.requests.OrderCreationRequest;
import ru.nsu.kondrenko.model.services.orders.response.OrderCreationResponse;
import ru.nsu.kondrenko.model.services.orders.response.OrderCreationStatus;
import ru.nsu.kondrenko.model.services.patients.PatientService;
import ru.nsu.kondrenko.model.services.patients.requests.PatientCreationRequest;
import ru.nsu.kondrenko.model.services.prescription.PrescriptionService;
import ru.nsu.kondrenko.model.services.prescription.requests.PrescriptionCreationRequest;
import ru.nsu.kondrenko.model.services.prescription.responses.PrescriptionCreationResponse;
import ru.nsu.kondrenko.model.services.prescription.responses.PrescriptionCreationStatus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class ConfirmOrderCreationController implements ActionListener {
    private final OrderService orderService;
    private final CustomerService customerService;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final PrescriptionService prescriptionService;

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Setter
    @Getter
    private View view;

    @Setter
    @Getter
    private OrderCreationForm orderCreationForm;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        final Customer customer = orderCreationForm.getCustomer();
        final ShortPrescription prescription = orderCreationForm.getPrescription();
        final Patient patient = prescription.getPatient();
        final Doctor doctor = prescription.getDoctor();

        if (customer.getFullName().isBlank()) {
            view.showError("Отсутствует ФИО клиента. Оформление прервано");
            return;
        }
        if (customer.getPhoneNumber().isBlank()) {
            view.showError("Отсутствует номер телефона клиента. Оформление прервано");
            return;
        }
        if (customer.getAddress().isBlank()) {
            view.showError("Отсутствует адрес клиента. Оформление прервано");
            return;
        }
        if (patient.getFullName().isBlank()) {
            view.showError("Отсутствует ФИО больного. Оформление прервано");
            return;
        }
        if (prescription.getDiagnosis().isBlank()) {
            view.showError("В рецепте отсутствует диагноз. Оформление прервано");
            return;
        }
        if (doctor.getFullName().isBlank()) {
            view.showError("В рецепте отсутствует врач. Оформление прервано");
            return;
        }
        if (prescription.getItems().isEmpty()) {
            view.showError("В рецепте отсутствуют лекарства. Оформление прервано");
            return;
        }

        try {
            final List<Doctor> doctors = doctorService.getDoctors();
            int doctorId = -1;
            for (final var it : doctors) {
                if (Objects.equals(it.getFullName(), doctor.getFullName())) {
                    doctorId = it.getId();
                }
            }
            if (doctorId == -1) {
                doctorId = doctorService.createDoctor(new DoctorCreationRequest(
                        doctor.getFullName()
                )).getDoctorId();
            }

            final List<Patient> patients = patientService.getPatients();

            int patientId = -1;
            for (final var it : patients) {
                final String d1 = simpleDateFormat.format(it.getBirthDate());
                final String d2 = simpleDateFormat.format(patient.getBirthDate());
                // TODO: fix
                // In some cases d1 != d2, but dates are exactly the same

                if (Objects.equals(it.getFullName(), patient.getFullName()) && Objects.equals(d1, d2)) {
                    patientId = it.getId();
                }
            }
            if (patientId == -1) {
                patientId = patientService.createPatient(new PatientCreationRequest(
                        patient.getFullName(),
                        patient.getBirthDate()
                )).getPatientId();
            }

            final List<Customer> customers = customerService.getCustomers();
            int customerId = -1;
            for (final var it : customers) {
                if (Objects.equals(it.getFullName(), customer.getFullName()) &&
                        Objects.equals(it.getPhoneNumber(), customer.getPhoneNumber()) && Objects.equals(it.getAddress(), customer.getAddress())) {
                    customerId = it.getId();
                }
            }
            if (customerId == -1) {
                final CustomerCreationResponse customerResponse = customerService.createCustomer(new CustomerCreationRequest(
                        customer.getFullName(),
                        customer.getPhoneNumber(),
                        customer.getAddress()
                ));

                if (customerResponse.getStatus() == CustomerCreationStatus.ALREADY_EXISTS_OR_INVALID) {
                    view.showError("Некорректные данные клиента. Оформление прервано");
                    return;
                }
                customerId = customerResponse.getCustomerId();
            }

            final PrescriptionCreationResponse prescriptionResponse = prescriptionService.createPrescription(
                    new PrescriptionCreationRequest(
                            prescription.getDiagnosis(),
                            patientId,
                            doctorId,
                            prescription.getDate(),
                            prescription.getItems()
                    )
            );

            if (prescriptionResponse.getStatus() == PrescriptionCreationStatus.INVALID) {
                view.showError("Некорректные данные рецепта. Оформление прервано");
                return;
            }

            final OrderCreationResponse orderResponse = orderService.createOrder(
                    new OrderCreationRequest(
                            prescriptionResponse.getPrescriptionId(),
                            customerId
                    )
            );

            if (orderResponse.getStatus() == OrderCreationStatus.INVALID) {
                view.showError("Некорректные данные заказа. Оформление прервано");
                return;
            }

            view.showInfo("Успешно оформлен заказ с номером %s".formatted(orderResponse.getOrderId()));
        } catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
            view.showNoConnectionError();
        }
    }
}
