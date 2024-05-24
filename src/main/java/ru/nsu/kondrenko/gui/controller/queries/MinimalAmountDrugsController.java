package ru.nsu.kondrenko.gui.controller.queries;

import ru.nsu.kondrenko.gui.controller.choosers.DrugTypeComboBox;
import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.gui.view.Utils;
import ru.nsu.kondrenko.model.dto.DrugType;
import ru.nsu.kondrenko.model.services.drug_types.DrugTypeService;
import ru.nsu.kondrenko.model.services.drugs.DrugService;

import javax.swing.*;
import java.util.List;

public class MinimalAmountDrugsController extends QueryController {
    private final DrugService drugService;
    private final DrugTypeService drugTypeService;

    private final DrugTypeComboBox drugTypeComboBox;
    private final JPanel dialogPanel;

    public MinimalAmountDrugsController(Filler filler, String queryName, DrugService drugService, DrugTypeService drugTypeService) {
        super(filler, queryName);
        this.drugService = drugService;
        this.drugTypeService = drugTypeService;
        drugTypeComboBox = new DrugTypeComboBox();
        dialogPanel = Utils.createDialogPanel(1);
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

        return drugService.getMinimalAmountDrugs(
                drugType != null ? drugType.getId() : null
        );
    }
}
