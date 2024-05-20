package ru.nsu.kondrenko.gui.controller.options;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.fillers.TableFiller;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.dto.Technology;
import ru.nsu.kondrenko.model.services.technologies.TechnologyService;
import ru.nsu.kondrenko.model.services.technologies.exceptions.TechnologyServiceException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@RequiredArgsConstructor
public class TechnologiesController implements ActionListener {
    private final TechnologyService technologyService;

    private final TableFiller filler;

    @Setter
    private View view;

    @Setter
    private JTable table;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            final List<Technology> technologies = technologyService.getTechnologies(
                    null,
                    null,
                    false
            );
            filler.fillTable(table, technologies.toArray());

            if (technologies.isEmpty()) {
                view.showInfo("Технологии не найдены");
            }
        } catch (TechnologyServiceException ignored) {
            view.showNoConnectionError();
        }
    }
}
