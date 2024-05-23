package ru.nsu.kondrenko.gui.controller.options;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.dto.Customer;
import ru.nsu.kondrenko.model.services.customers.CustomerService;
import ru.nsu.kondrenko.model.services.customers.exceptions.CustomerServiceException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@RequiredArgsConstructor
public class WaitingSuppliesCustomersController implements ActionListener {
    private final CustomerService customerService;

    private final Filler filler;

    @Setter
    private View view;

    @Setter
    private JTable table;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            final List<Customer> waitingSuppliesCustomers = customerService.getWaitingSuppliesCustomers(
                    null
            );
            filler.fillTable(table, waitingSuppliesCustomers.toArray());

            if (waitingSuppliesCustomers.isEmpty()) {
                view.showInfo("Клиенты, ожидающие поставки, не найдены");
            }
        } catch (CustomerServiceException ignored) {
            view.showNoConnectionError();
        }
    }
}
