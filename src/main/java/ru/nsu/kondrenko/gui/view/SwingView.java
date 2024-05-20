package ru.nsu.kondrenko.gui.view;

import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import ru.nsu.kondrenko.gui.controller.fillers.*;
import ru.nsu.kondrenko.gui.controller.options.*;
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

        final TableFiller orderFiller = new OrderTableFiller();
        final TableFiller drugFiller = new DrugTableFiller();
        final TableFiller customerFiller = new CustomerTableFiller();
        final TableFiller frequentCustomerFiller = new FrequentCustomerTableFiller();
        final TableFiller usedDrugFiller = new UsedDrugTableFiller();
        final TableFiller technologyFiller = new TechnologyTableFiller();
        final TableFiller storedDrugFiller = new StoredDrugTableFiller();
        final TableFiller productionComponentFiller = new ProductionComponentTableFiller();

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
                drugService,
                drugFiller
        );
        final OrdersController ordersController = new OrdersController(
                orderService,
                orderFiller
        );
        final ForgottenOrdersController forgottenOrdersController = new ForgottenOrdersController(
                orderService,
                orderFiller
        );
        final ProductionOrdersController productionOrdersController = new ProductionOrdersController(
                orderService,
                orderFiller
        );
        final WaitingSuppliesCustomersController waitingCustomersController = new WaitingSuppliesCustomersController(
                customerService,
                customerFiller
        );
        final FrequentCustomersController frequentCustomersController = new FrequentCustomersController(
                customerService,
                frequentCustomerFiller
        );
        final OrderedSomethingCustomersController orderedSomethingCustomersController = new OrderedSomethingCustomersController(
                customerService,
                customerFiller
        );
        final PopularDrugsController popularDrugsController = new PopularDrugsController(
                drugService,
                usedDrugFiller
        );
        final UsedDrugsController usedDrugsController = new UsedDrugsController(
                drugService,
                usedDrugFiller
        );
        final CriticalAmountDrugsController criticalAmountDrugsController = new CriticalAmountDrugsController(
                drugService,
                drugFiller
        );
        final ProductionComponentsController productionComponentsController = new ProductionComponentsController(
                productionService,
                productionComponentFiller
        );
        final MinimalAmountDrugsController minimalAmountDrugsController = new MinimalAmountDrugsController(
                drugService,
                storedDrugFiller
        );
        final TechnologiesController technologiesController = new TechnologiesController(
                technologyService,
                technologyFiller
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
    public void showNoConnectionError() {
        showError(Constants.NO_CONNECTION_ERROR_MESSAGE);
    }

    @Override
    public void showEmptyResultInfo() {
        showInfo("Ничего не найдено");
    }

    @Override
    public boolean showConfirmationDialog(String title, JPanel content) {
        return JOptionPane.showConfirmDialog(
                mainWindow,
                content,
                title,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION;
    }

    @Override
    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(
                mainWindow,
                errorMessage,
                "Ошибка",
                JOptionPane.ERROR_MESSAGE
        );
    }

    @Override
    public void showInfo(String infoMessage) {
        JOptionPane.showMessageDialog(
                mainWindow,
                infoMessage,
                "Сообщение",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
