package ru.nsu.kondrenko.gui.view;

import ru.nsu.kondrenko.gui.controller.*;

import javax.swing.*;
import javax.swing.table.TableModel;
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

        ordersController.setTable(table);
        drugsController.setTable(table);

        pack();
    }
}
