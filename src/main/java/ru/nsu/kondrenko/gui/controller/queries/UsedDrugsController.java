package ru.nsu.kondrenko.gui.controller.queries;

import ru.nsu.kondrenko.gui.controller.choosers.DatePicker;
import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.gui.view.Utils;
import ru.nsu.kondrenko.model.services.drugs.DrugService;

import javax.swing.*;
import java.util.List;

public class UsedDrugsController extends QueryController {
    private final DrugService drugService;

    private final DatePicker startDatePicker;
    private final DatePicker endDatePicker;
    private final JPanel dialogPanel;

    public UsedDrugsController(Filler filler, String queryName, DrugService drugService) {
        super(filler, queryName);
        this.drugService = drugService;
        startDatePicker = new DatePicker();
        endDatePicker = new DatePicker();
        dialogPanel = Utils.createDialogPanel(2);
        Utils.addComponentToPanel(dialogPanel, "Начало", startDatePicker);
        Utils.addComponentToPanel(dialogPanel, "Конец", endDatePicker);
    }

    @Override
    protected List<?> getResult() throws Exception {
        final boolean ok = getView().showConfirmationDialog("Название", dialogPanel);
        if (!ok) {
            return null;
        }

        return drugService.getUsedDrugs(
                startDatePicker.getDate(),
                endDatePicker.getDate()
        );
    }
}
