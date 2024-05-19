package ru.nsu.kondrenko.gui.controller;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.services.customers.CustomerService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@RequiredArgsConstructor
public class FrequentCustomersController implements ActionListener {
    private final CustomerService customerService;

    @Setter
    private View view;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
