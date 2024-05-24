package ru.nsu.kondrenko.gui.view;

import ru.nsu.kondrenko.gui.controller.CreateOrderController;
import ru.nsu.kondrenko.gui.controller.ObtainOrderController;
import ru.nsu.kondrenko.gui.controller.PayOrderController;
import ru.nsu.kondrenko.gui.controller.queries.*;

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
            WaitingSuppliesCustomersController waitingCustomersController,
            FrequentCustomersController frequentCustomersController,
            OrderedSomethingCustomersController orderedSomethingCustomersController,
            PopularDrugsController popularDrugsController,
            UsedDrugsController usedDrugsController,
            CriticalAmountDrugsController criticalAmountDrugsController,
            ProductionComponentsController productionComponentsController,
            MinimalAmountDrugsController minimalAmountDrugsController,
            TechnologiesController technologiesController) {
        final JPanel optionsPanel = new OptionsPanel(
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

        final JScrollPane scrollPane = new JScrollPane(optionsPanel);
        add(scrollPane, BorderLayout.WEST);

        final CentralPanel centralPanel = new CentralPanel();
        add(centralPanel, BorderLayout.CENTER);

        final JTable table = centralPanel.getTable();

        productionComponentsController.setTable(table);
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
