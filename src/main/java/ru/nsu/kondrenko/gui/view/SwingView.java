package ru.nsu.kondrenko.gui.view;

import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import ru.nsu.kondrenko.gui.controller.*;
import ru.nsu.kondrenko.model.services.customers.CustomerService;
import ru.nsu.kondrenko.model.services.doctors.DoctorService;
import ru.nsu.kondrenko.model.services.drug_types.DrugTypeService;
import ru.nsu.kondrenko.model.services.drugs.DrugService;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.patients.PatientService;
import ru.nsu.kondrenko.model.services.prescription.PrescriptionService;
import ru.nsu.kondrenko.model.services.production.ProductionService;
import ru.nsu.kondrenko.model.services.technologies.TechnologyService;

import javax.swing.*;

public class SwingView implements View {
    private final MainWindow mainWindow;

    public SwingView(
            CustomerService customerService,
            DoctorService doctorService,
            DrugTypeService drugTypeService,
            DrugService drugService,
            OrderService orderService,
            PatientService patientService,
            PrescriptionService prescriptionService,
            ProductionService productionService,
            TechnologyService technologyService) {
        FlatGrayIJTheme.setup();

        final CreateOrderController createOrderController = new CreateOrderController(
                orderService
        );
        final PayOrderController payOrderController = new PayOrderController(
                orderService
        );
        final ObtainOrderController obtainOrderController = new ObtainOrderController(
                orderService
        );
        final DrugsController drugsController = new DrugsController(
                drugService
        );
        final OrdersController ordersController = new OrdersController(
                orderService
        );
        final ForgottenOrdersController forgottenOrdersController = new ForgottenOrdersController(
                orderService
        );
        final ProductionOrdersController productionOrdersController = new ProductionOrdersController(
                orderService
        );
        final WaitingCustomersController waitingCustomersController = new WaitingCustomersController(
                customerService
        );
        final FrequentCustomersController frequentCustomersController = new FrequentCustomersController(
                customerService
        );
        final OrderedSomethingCustomersController orderedSomethingCustomersController = new OrderedSomethingCustomersController(
                customerService
        );
        final PopularDrugsController popularDrugsController = new PopularDrugsController(
                drugService
        );
        final UsedDrugsController usedDrugsController = new UsedDrugsController(
                drugService
        );
        final CriticalAmountDrugsController criticalAmountDrugsController = new CriticalAmountDrugsController(
                drugService
        );
        final ProductionComponentsController productionComponentsController = new ProductionComponentsController(
                productionService
        );
        final MinimalAmountDrugsController minimalAmountDrugsController = new MinimalAmountDrugsController(
                drugService
        );
        final TechnologiesController technologiesController = new TechnologiesController(
                technologyService
        );

        createOrderController.setView(this);
        payOrderController.setView(this);
        obtainOrderController.setView(this);
        drugsController.setView(this);
        ordersController.setView(this);
        forgottenOrdersController.setView(this);
        productionOrdersController.setView(this);
        waitingCustomersController.setView(this);
        frequentCustomersController.setView(this);
        orderedSomethingCustomersController.setView(this);
        popularDrugsController.setView(this);
        usedDrugsController.setView(this);
        criticalAmountDrugsController.setView(this);
        productionComponentsController.setView(this);
        minimalAmountDrugsController.setView(this);
        technologiesController.setView(this);

        mainWindow = new MainWindow(
                createOrderController,
                 payOrderController,
                 obtainOrderController,
                 drugsController,
                 ordersController,
                 forgottenOrdersController,
                 productionOrdersController,
                 waitingCustomersController,
                 frequentCustomersController,
                 orderedSomethingCustomersController,
                 popularDrugsController,
                 usedDrugsController,
                 criticalAmountDrugsController,
                 productionComponentsController,
                 minimalAmountDrugsController,
                 technologiesController
        );

        mainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void show() {
        mainWindow.setVisible(true);
    }

    @Override
    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(
                mainWindow,
                errorMessage,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
