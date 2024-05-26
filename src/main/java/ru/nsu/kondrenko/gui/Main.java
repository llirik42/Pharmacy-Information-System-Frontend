package ru.nsu.kondrenko.gui;

import ru.nsu.kondrenko.gui.view.SwingView;
import ru.nsu.kondrenko.model.Context;
import ru.nsu.kondrenko.model.services.ServiceConfig;
import ru.nsu.kondrenko.model.services.customers.CustomerService;
import ru.nsu.kondrenko.model.services.customers.impl.CustomerServiceImpl;
import ru.nsu.kondrenko.model.services.doctors.DoctorService;
import ru.nsu.kondrenko.model.services.doctors.impl.DoctorServiceImpl;
import ru.nsu.kondrenko.model.services.drug_types.DrugTypeService;
import ru.nsu.kondrenko.model.services.drug_types.impl.DrugTypeServiceImpl;
import ru.nsu.kondrenko.model.services.drugs.DrugService;
import ru.nsu.kondrenko.model.services.drugs.impl.DrugServiceImpl;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;
import ru.nsu.kondrenko.model.services.orders.impl.OrderServiceImpl;
import ru.nsu.kondrenko.model.services.patients.PatientService;
import ru.nsu.kondrenko.model.services.patients.impl.PatientServiceImpl;
import ru.nsu.kondrenko.model.services.prescription.PrescriptionService;
import ru.nsu.kondrenko.model.services.prescription.impl.PrescriptionServiceImpl;
import ru.nsu.kondrenko.model.services.production.ProductionService;
import ru.nsu.kondrenko.model.services.production.impl.ProductionServiceImpl;
import ru.nsu.kondrenko.model.services.technologies.TechnologyService;
import ru.nsu.kondrenko.model.services.technologies.impl.TechnologyServiceImpl;

public class Main {
    public static void main(String[] args) throws OrderServiceException {
        final ServiceConfig config = new ServiceConfig(
                "localhost",
                8000
        );

        final CustomerService customerService = new CustomerServiceImpl(config);
        final DoctorService doctorService = new DoctorServiceImpl(config);
        final DrugTypeService drugTypeService = new DrugTypeServiceImpl(config);
        final DrugService drugService = new DrugServiceImpl(config);
        final OrderService orderService = new OrderServiceImpl(config);
        final PatientService patientService = new PatientServiceImpl(config);
        final PrescriptionService prescriptionService = new PrescriptionServiceImpl(config);
        final ProductionService productionService = new ProductionServiceImpl(config);
        final TechnologyService technologyService = new TechnologyServiceImpl(config);

        final Context context = new Context();

        final View view = new SwingView(
                context,
                customerService,
                doctorService,
                drugTypeService,
                drugService,
                orderService,
                patientService,
                prescriptionService,
                productionService,
                technologyService
        );

        view.show();
    }
}
