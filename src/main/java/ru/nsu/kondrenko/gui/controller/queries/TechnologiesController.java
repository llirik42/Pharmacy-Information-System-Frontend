package ru.nsu.kondrenko.gui.controller.queries;

import ru.nsu.kondrenko.gui.controller.choosers.DrugComboBox;
import ru.nsu.kondrenko.gui.controller.choosers.DrugTypeComboBox;
import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.gui.view.Utils;
import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.dto.DrugType;
import ru.nsu.kondrenko.model.services.drug_types.DrugTypeService;
import ru.nsu.kondrenko.model.services.drugs.DrugService;
import ru.nsu.kondrenko.model.services.technologies.TechnologyService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TechnologiesController extends QueryController {
    private final TechnologyService technologyService;
    private final DrugService drugService;
    private final DrugTypeService drugTypeService;

    private final DrugComboBox drugComboBox;
    private final DrugTypeComboBox drugTypeComboBox;
    private final Checkbox checkbox;
    private final JPanel dialogPanel;

    public TechnologiesController(Filler filler, String queryName, TechnologyService technologyService, DrugService drugService, DrugTypeService drugTypeService) {
        super(filler, queryName);
        this.technologyService = technologyService;
        this.drugService = drugService;
        this.drugTypeService = drugTypeService;
        drugComboBox = new DrugComboBox();
        drugTypeComboBox = new DrugTypeComboBox();
        checkbox = new Checkbox();
        dialogPanel = Utils.createDialogPanel(3);
        Utils.addComponentToPanel(dialogPanel, "Лекарство", drugComboBox);
        Utils.addComponentToPanel(dialogPanel, "Тип лекарства", drugTypeComboBox);
        Utils.addComponentToPanel(dialogPanel, "В производстве", checkbox);
    }

    @Override
    protected List<?> getResult() throws Exception {
        drugComboBox.setDrugList(drugService.getDrugs());
        drugTypeComboBox.setDrugTypeList(drugTypeService.getDrugTypes());

        final boolean ok = getView().showConfirmationDialog("Данные для поиска", dialogPanel);
        if (!ok) {
            return null;
        }

        final Drug drug = drugComboBox.getSelectedDrug();
        final DrugType drugType = drugTypeComboBox.getSelectedDrugType();

        return technologyService.getTechnologies(
                drug != null ? drug.getId() : null,
                drugType != null ? drugType.getId() : null,
                checkbox.getState()
        );
    }
}
