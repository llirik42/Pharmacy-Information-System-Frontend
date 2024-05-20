package ru.nsu.kondrenko.gui.controller.options;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.fillers.TableFiller;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.dto.StoredDrug;
import ru.nsu.kondrenko.model.services.drugs.DrugService;
import ru.nsu.kondrenko.model.services.drugs.exceptions.DrugServiceException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@RequiredArgsConstructor
public class MinimalAmountDrugsController implements ActionListener {
    private final DrugService drugService;

    private final TableFiller filler;

    @Setter
    private View view;

    @Setter
    private JTable table;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            final List<StoredDrug> minimalAmountDrugs = drugService.getMinimalAmountDrugs(
                    null
            );
            filler.fillTable(table, minimalAmountDrugs.toArray());

            if (minimalAmountDrugs.isEmpty()) {
                view.showInfo("Медикаменты с минимальным запасом не найдены");
            }
        } catch (DrugServiceException ignored) {
            view.showNoConnectionError();
        }
    }
}
