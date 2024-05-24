package ru.nsu.kondrenko.gui.controller.queries;

import ru.nsu.kondrenko.gui.controller.choosers.DrugComboBox;
import ru.nsu.kondrenko.gui.controller.choosers.DrugTypeComboBox;
import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.gui.view.Utils;
import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.dto.DrugType;
import ru.nsu.kondrenko.model.services.customers.CustomerService;
import ru.nsu.kondrenko.model.services.drug_types.DrugTypeService;
import ru.nsu.kondrenko.model.services.drugs.DrugService;

import javax.swing.*;
import java.util.List;

public class FrequentCustomersController extends QueryController {
    private final CustomerService customerService;
    private final DrugService drugService;
    private final DrugTypeService drugTypeService;

    private final DrugComboBox drugComboBox;
    private final DrugTypeComboBox drugTypeComboBox;
    private final JPanel dialogPanel;

    public FrequentCustomersController(Filler filler, String queryName, CustomerService customerService, DrugService drugService, DrugTypeService drugTypeService) {
        super(filler, queryName);
        this.customerService = customerService;
        this.drugService = drugService;
        this.drugTypeService = drugTypeService;
        drugComboBox = new DrugComboBox();
        drugTypeComboBox = new DrugTypeComboBox();
        dialogPanel = Utils.createDialogPanel(2);
        Utils.addComponentToPanel(dialogPanel, "Лекарство", drugTypeComboBox);
        Utils.addComponentToPanel(dialogPanel, "Тип лекарства", drugTypeComboBox);
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

        return customerService.getFrequentCustomers(
                drug != null ? drugType.getId() : null,
                drugType != null ? drugType.getId() : null
        );
    }
}
