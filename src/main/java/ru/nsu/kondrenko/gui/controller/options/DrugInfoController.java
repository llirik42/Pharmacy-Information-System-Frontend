package ru.nsu.kondrenko.gui.controller.options;

import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.OptionController;
import ru.nsu.kondrenko.gui.controller.utils.input.DialogPanel;
import ru.nsu.kondrenko.gui.controller.utils.input.DrugComboBox;
import ru.nsu.kondrenko.gui.view.central.DrugInfoPanel;
import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.services.drugs.DrugService;
import ru.nsu.kondrenko.model.services.drugs.exceptions.DrugServiceException;

import java.awt.event.ActionEvent;

public class DrugInfoController extends OptionController {
    private final DrugService drugService;

    private final DrugComboBox drugComboBox;
    private final DialogPanel dialogPanel;

    @Setter
    private DrugInfoPanel drugInfoPanel;

    public DrugInfoController(String optionName, DrugService drugService) {
        super(optionName);

        this.drugService = drugService;
        drugComboBox = new DrugComboBox(false);
        dialogPanel = new DialogPanel(1);
        dialogPanel.addComponent("Медикамент", drugComboBox);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            drugComboBox.setDrugList(drugService.getDrugs());
        } catch (DrugServiceException exception) {
            getView().showNoConnectionError();
            return;
        }

        final boolean ok = getView().showConfirmationDialog("Выбор медикамента", dialogPanel);
        if (!ok) {
            return;
        }

        final Drug drug = drugComboBox.getSelectedDrug();
        drugInfoPanel.update(drug);
        getView().showDrugInfo();
        setLabel();
    }
}
