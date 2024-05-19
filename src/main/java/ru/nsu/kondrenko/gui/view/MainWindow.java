package ru.nsu.kondrenko.gui.view;

import ru.nsu.kondrenko.gui.controller.*;

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
            MinimalAmounDrugsController minimalAmounDrugsController,
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
                minimalAmounDrugsController,
                technologiesController
        ), BorderLayout.WEST);

        final CentralPanel centralPanel = new CentralPanel();
        add(centralPanel, BorderLayout.CENTER);
        final TableModel tableModel = centralPanel.getTable().getModel();

        ordersController.setTableModel(tableModel);

        pack();
    }
}
