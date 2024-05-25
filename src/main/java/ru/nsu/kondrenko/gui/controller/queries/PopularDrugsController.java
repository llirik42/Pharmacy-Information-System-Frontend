package ru.nsu.kondrenko.gui.controller.queries;

import ru.nsu.kondrenko.gui.controller.choosers.DrugTypeComboBox;
import ru.nsu.kondrenko.gui.controller.choosers.IntegerSpinner;
import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.gui.view.Utils;
import ru.nsu.kondrenko.model.dto.DrugType;
import ru.nsu.kondrenko.model.services.drug_types.DrugTypeService;
import ru.nsu.kondrenko.model.services.drugs.DrugService;

import javax.swing.*;
import java.util.List;

public class PopularDrugsController extends QueryController {
    private final DrugService drugService;
    private final DrugTypeService drugTypeService;

    private final IntegerSpinner limitSpinner;
    private final DrugTypeComboBox drugTypeComboBox;
    private final JPanel dialogPanel;

    public PopularDrugsController(Filler filler, String queryName, DrugService drugService, DrugTypeService drugTypeService) {
        super(filler, queryName);
        this.drugService = drugService;
        this.drugTypeService = drugTypeService;
        limitSpinner = new IntegerSpinner(1, 20, 10);
        drugTypeComboBox = new DrugTypeComboBox();
        dialogPanel = Utils.createDialogPanel(2);
        Utils.addComponentToPanel(dialogPanel, "Кол-во", limitSpinner);
        Utils.addComponentToPanel(dialogPanel, "Тип лекарства", drugTypeComboBox);
    }

    @Override
    protected List<?> getResult() throws Exception {
        drugTypeComboBox.setDrugTypeList(drugTypeService.getDrugTypes());

        final boolean ok = getView().showConfirmationDialog("Данные для поиска", dialogPanel);
        if (!ok) {
            return null;
        }

        final DrugType drugType = drugTypeComboBox.getSelectedDrugType();

        return drugService.getPopularDrugs(
                limitSpinner.getIntValue(),
                drugType != null ? drugType.getId() : null
        );
    }
}
