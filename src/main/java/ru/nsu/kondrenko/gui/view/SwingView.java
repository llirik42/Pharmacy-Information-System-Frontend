package ru.nsu.kondrenko.gui.view;

import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import ru.nsu.kondrenko.gui.controller.CreateOrderController;
import ru.nsu.kondrenko.gui.controller.ObtainOrderController;
import ru.nsu.kondrenko.gui.controller.PayOrderController;
import ru.nsu.kondrenko.gui.controller.fillers.*;
import ru.nsu.kondrenko.gui.controller.queries.*;
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

        final Filler orderFiller = new OrderFiller();
        final Filler drugFiller = new DrugFiller();
        final Filler customerFiller = new CustomerFiller();
        final Filler frequentCustomerFiller = new FrequentCustomerFiller();
        final Filler usedDrugFiller = new UsedDrugFiller();
        final Filler technologyFiller = new TechnologyFiller();
        final Filler storedDrugFiller = new StoredDrugFiller();
        final Filler productionComponentFiller = new ProductionComponentFiller();

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
                drugFiller,
                "Медикаменты",
                drugService
        );
        final OrdersController ordersController = new OrdersController(
                orderFiller,
                "Заказы",
                orderService
        );
        final ForgottenOrdersController forgottenOrdersController = new ForgottenOrdersController(
                orderFiller,
                "Не забранные вовремя заказы",
                orderService
        );
        final ProductionOrdersController productionOrdersController = new ProductionOrdersController(
                orderFiller,
                "Заказы в производстве",
                orderService
        );
        final WaitingSuppliesCustomersController waitingCustomersController = new WaitingSuppliesCustomersController(
                customerFiller,
                "Ожидающие поставок клиенты",
                customerService,
                drugTypeService
        );
        final FrequentCustomersController frequentCustomersController = new FrequentCustomersController(
                frequentCustomerFiller,
                "Часто делающие заказы клиенты",
                customerService,
                drugService,
                drugTypeService
        );
        final OrderedSomethingCustomersController orderedSomethingCustomersController = new OrderedSomethingCustomersController(
                customerFiller,
                "Клиенты, заказавшие медикаменты",
                customerService,
                drugService,
                drugTypeService
        );
        final PopularDrugsController popularDrugsController = new PopularDrugsController(
                usedDrugFiller,
                "Часто используемые медикаменты",
                drugService
        );
        final UsedDrugsController usedDrugsController = new UsedDrugsController(
                usedDrugFiller,
                "Использованные медикаменты",
                drugService
        );
        final CriticalAmountDrugsController criticalAmountDrugsController = new CriticalAmountDrugsController(
                drugFiller,
                "Медикаменты с критической нормой/закончившиеся",
                drugService
        );
        final ProductionComponentsController productionComponentsController = new ProductionComponentsController(
                productionComponentFiller,
                "Требуемые для производства медикаменты",
                productionService
        );
        final MinimalAmountDrugsController minimalAmountDrugsController = new MinimalAmountDrugsController(
                storedDrugFiller,
                "Медикаменты с минимальным запасом",
                drugService,
                drugTypeService
        );
        final TechnologiesController technologiesController = new TechnologiesController(
                technologyFiller,
                "Технологии",
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
    public void showNoConnectionError() {
        showError(Constants.NO_CONNECTION_ERROR_MESSAGE);
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
