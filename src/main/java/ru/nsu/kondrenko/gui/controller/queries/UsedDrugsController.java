package ru.nsu.kondrenko.gui.controller.queries;

import ru.nsu.kondrenko.gui.controller.utils.DatePicker;
import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.gui.controller.utils.DialogPanel;
import ru.nsu.kondrenko.model.services.drugs.DrugService;

import java.util.List;

public class UsedDrugsController extends QueryController {
    private final DrugService drugService;

    private final DatePicker startDatePicker;
    private final DatePicker endDatePicker;
    private final DialogPanel dialogPanel;

    public UsedDrugsController(Filler filler, String queryName, DrugService drugService) {
        super(filler, queryName);
        this.drugService = drugService;

        startDatePicker = new DatePicker();
        endDatePicker = new DatePicker();
        dialogPanel = new DialogPanel(2);
        dialogPanel.addComponent("Начало", startDatePicker);
        dialogPanel.addComponent("Конец", endDatePicker);
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
