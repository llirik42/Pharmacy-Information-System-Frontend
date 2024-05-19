package ru.nsu.kondrenko.gui.view;

import ru.nsu.kondrenko.gui.controller.options.*;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends Window {
    public MainWindow(
            CreateOrderController createOrderController,
            PayOrderController payOrderController,
            ObtainOrderController obtainOrderController,
            DrugsController drugsController,
            OrdersController ordersController,
            ForgottenOrdersController forgottenOrdersController,
            ProductionOrdersController productionOrdersController,
            WaitingCustomersController waitingCustomersController,
            FrequentCustomersController frequentCustomersController,
            OrderedSomethingCustomersController orderedSomethingCustomersController,
            PopularDrugsController popularDrugsController,
            UsedDrugsController usedDrugsController,
            CriticalAmountDrugsController criticalAmountDrugsController,
            ProductionComponentsController productionComponentsController,
            MinimalAmountDrugsController minimalAmountDrugsController,
            TechnologiesController technologiesController) {
        add(new OptionsPanel(
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
        ), BorderLayout.WEST);

        final CentralPanel centralPanel = new CentralPanel();
        add(centralPanel, BorderLayout.CENTER);

        final JTable table = centralPanel.getTable();

        orderedSomethingCustomersController.setTable(table);
        minimalAmountDrugsController.setTable(table);
        usedDrugsController.setTable(table);
        frequentCustomersController.setTable(table);
        criticalAmountDrugsController.setTable(table);
        productionOrdersController.setTable(table);
        waitingCustomersController.setTable(table);
        popularDrugsController.setTable(table);
        forgottenOrdersController.setTable(table);
        ordersController.setTable(table);
        technologiesController.setTable(table);
        drugsController.setTable(table);

        pack();
    }
}
