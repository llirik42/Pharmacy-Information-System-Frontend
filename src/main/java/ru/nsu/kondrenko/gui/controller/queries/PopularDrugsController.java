package ru.nsu.kondrenko.gui.controller.queries;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.dto.UsedDrug;
import ru.nsu.kondrenko.model.services.drugs.DrugService;
import ru.nsu.kondrenko.model.services.drugs.exceptions.DrugServiceException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@RequiredArgsConstructor
public class PopularDrugsController implements ActionListener {
    private final DrugService drugService;

    private final Filler filler;

    @Setter
    private View view;

    @Setter
    private JTable table;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            final List<UsedDrug> popularDrugs = drugService.getPopularDrugs(
                    10,
                    null
            );
            filler.fillTable(table, popularDrugs.toArray());

            if (popularDrugs.isEmpty()) {
                view.showInfo("Популярные медикаменты не найдены");
            }
        } catch (DrugServiceException ignored) {
            view.showNoConnectionError();
        }
    }
}
