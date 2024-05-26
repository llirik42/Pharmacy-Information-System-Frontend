package ru.nsu.kondrenko.gui.view;

import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import ru.nsu.kondrenko.gui.controller.*;
import ru.nsu.kondrenko.gui.controller.fillers.*;
import ru.nsu.kondrenko.gui.controller.queries.*;
import ru.nsu.kondrenko.model.Context;
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
import java.util.List;

public class SwingView implements View {
    private final MainWindow mainWindow;

    public SwingView(
            Context context,
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

        final List<OptionController> optionControllers = List.of(
                new CreateOrderController(
                        "Оформление заказа",
                        orderService
                ),
                new PayOrderController(
                        "Оплата заказа",
                        orderService
                ),
                new ObtainOrderController(
                        "Получение заказа",
                        orderService
                ),
                new DrugInfoController(
                        "Информация о медикаменте",
                        drugService
                ),
                new OrderInfoController(
                        "Информация о заказе",
                        orderService
                )
        );

        final List<QueryController> queryControllers = List.of(
                new DrugsController(
                        drugFiller,
                        "Медикаменты",
                        drugService
                ),
                new OrdersController(
                        orderFiller,
                        "Заказы",
                        orderService
                ),
                new ForgottenOrdersController(
                        orderFiller,
                        "Не забранные вовремя заказы",
                        orderService
                ),
                new ProductionOrdersController(
                        orderFiller,
                        "Заказы в производстве",
                        orderService
                ),
                new WaitingSuppliesCustomersController(
                        customerFiller,
                        "Ожидающие поставок клиенты",
                        customerService,
                        drugTypeService
                ),
                new FrequentCustomersController(
                        frequentCustomerFiller,
                        "Часто делающие заказы клиенты",
                        customerService,
                        drugService,
                        drugTypeService
                ),
                new OrderedSomethingCustomersController(
                        customerFiller,
                        "Клиенты, заказавшие медикаменты",
                        customerService,
                        drugService,
                        drugTypeService
                ),
                new PopularDrugsController(
                        usedDrugFiller,
                        "Часто используемые медикаменты",
                        drugService,
                        drugTypeService
                ),
                new UsedDrugsController(
                        usedDrugFiller,
                        "Использованные медикаменты",
                        drugService
                ),
                new CriticalAmountDrugsController(
                        drugFiller,
                        "Медикаменты с критической нормой/закончившиеся",
                        drugService
                ),
                new ProductionComponentsController(
                        productionComponentFiller,
                        "Требуемые для производства медикаменты",
                        productionService
                ),
                new MinimalAmountDrugsController(
                        storedDrugFiller,
                        "Медикаменты с минимальным запасом",
                        drugService,
                        drugTypeService
                ),
                new TechnologiesController(
                        technologyFiller,
                        "Технологии",
                        technologyService,
                        drugService,
                        drugTypeService
                )
        );

        for (final var it : optionControllers) {
            it.setView(this);
            it.setContext(context);
        }
        for (final var it : queryControllers) {
            it.setView(this);
            it.setContext(context);
        }

        mainWindow = new MainWindow(optionControllers, queryControllers);
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
