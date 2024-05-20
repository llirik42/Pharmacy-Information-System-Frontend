package ru.nsu.kondrenko.gui.controller.options;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.fillers.TableFiller;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.dto.FrequentCustomer;
import ru.nsu.kondrenko.model.services.customers.CustomerService;
import ru.nsu.kondrenko.model.services.customers.exceptions.CustomerServiceException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@RequiredArgsConstructor
public class FrequentCustomersController implements ActionListener {
    private final CustomerService customerService;

    private final TableFiller filler;

    @Setter
    private View view;

    @Setter
    private JTable table;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            final List<FrequentCustomer> frequentCustomers = customerService.getFrequentCustomers(
                    null,
                    null
            );
            filler.fillTable(table, frequentCustomers.toArray());

            if (frequentCustomers.isEmpty()) {
                view.showInfo("Постоянные клиенты не найдены");
            }
        } catch (CustomerServiceException ignored) {
            view.showNoConnectionError();
        }
    }
}
