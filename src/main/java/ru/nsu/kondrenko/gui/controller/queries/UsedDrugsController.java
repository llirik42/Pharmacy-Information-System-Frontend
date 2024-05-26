package ru.nsu.kondrenko.gui.controller.queries;

import ru.nsu.kondrenko.gui.controller.QueryController;
import ru.nsu.kondrenko.gui.controller.utils.fillers.Filler;
import ru.nsu.kondrenko.gui.controller.utils.input.DatePicker;
import ru.nsu.kondrenko.gui.controller.utils.input.DialogPanel;
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
        dialogPanel.addComponent("Начало периода", startDatePicker);
        dialogPanel.addComponent("Конец периода", endDatePicker);
    }

    @Override
    protected List<?> getResult() throws Exception {
        final boolean ok = getView().showConfirmationDialog("Данные для поиска", dialogPanel);
        if (!ok) {
            return null;
        }

        return drugService.getUsedDrugs(
                startDatePicker.getDate(),
                endDatePicker.getDate()
        );
    }
}
