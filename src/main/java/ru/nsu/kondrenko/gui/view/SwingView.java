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

        final CreateOrderController createOrderController = new CreateOrderController();
        final PayOrderController payOrderController = new PayOrderController();
        final ObtainOrderController obtainOrderController = new ObtainOrderController();
        final DrugsController drugsController = new DrugsController(drugService);
        final OrdersController ordersController = new OrdersController(orderService);
        final ForgottenOrdersController forgottenOrdersController = new ForgottenOrdersController();
        final ProductionOrdersController productionOrdersController = new ProductionOrdersController();
        final WaitingCustomersController waitingCustomersController = new WaitingCustomersController();
        final FrequentCustomersController frequentCustomersController = new FrequentCustomersController();
        final OrderedSomethingCustomersController orderedSomethingCustomersController = new OrderedSomethingCustomersController();
        final PopularDrugsController popularDrugsController = new PopularDrugsController();
        final UsedDrugsController usedDrugsController = new UsedDrugsController();
        final CriticalAmountDrugsController criticalAmountDrugsController = new CriticalAmountDrugsController();
        final ProductionComponentsController productionComponentsController = new ProductionComponentsController();
        final MinimalAmounDrugsController minimalAmounDrugsController = new MinimalAmounDrugsController();
        final TechnologiesController technologiesController = new TechnologiesController();

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
                 minimalAmounDrugsController,
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
