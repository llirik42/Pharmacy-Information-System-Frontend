package ru.nsu.kondrenko.gui.controller;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.services.technologies.TechnologyService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@RequiredArgsConstructor
public class TechnologiesController implements ActionListener {
    private final TechnologyService technologyService;

    @Setter
    private View view;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
