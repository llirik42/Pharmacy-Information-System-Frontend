package ru.nsu.kondrenko.gui.controller.queries;

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
public class OrderedSomethingCustomersController implements ActionListener {
    private final CustomerService customerService;

    private final Filler filler;

    @Setter
    private View view;

    @Setter
    private JTable table;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            final List<Customer> orderedSomethingCustomers = customerService.getOrderedSomethingCustomers(
                    null,
                    null,
                    null,
                    null
            );
            filler.fillTable(table, orderedSomethingCustomers.toArray());

            if (orderedSomethingCustomers.isEmpty()) {
                view.showInfo("Клиенты, заказавшие медикаменты, не найдены");
            }
        } catch (CustomerServiceException ignored) {
            view.showNoConnectionError();
        }
    }
}
