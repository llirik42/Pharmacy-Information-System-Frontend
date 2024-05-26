package ru.nsu.kondrenko.gui.controller.queries;

import ru.nsu.kondrenko.gui.controller.QueryController;
import ru.nsu.kondrenko.gui.controller.utils.fillers.Filler;
import ru.nsu.kondrenko.gui.controller.utils.input.DialogPanel;
import ru.nsu.kondrenko.gui.controller.utils.input.DrugComboBox;
import ru.nsu.kondrenko.gui.controller.utils.input.AdministrationRouteComboBox;
import ru.nsu.kondrenko.gui.controller.utils.input.DrugTypeComboBox;
import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.dto.DrugType;
import ru.nsu.kondrenko.model.services.customers.CustomerService;
import ru.nsu.kondrenko.model.services.drug_types.DrugTypeService;
import ru.nsu.kondrenko.model.services.drugs.DrugService;

import java.util.List;

public class FrequentCustomersController extends QueryController {
    private final CustomerService customerService;
    private final DrugService drugService;
    private final DrugTypeService drugTypeService;

    private final DrugComboBox drugComboBox;
    private final DrugTypeComboBox drugTypeComboBox;
    private final DialogPanel dialogPanel;

    public FrequentCustomersController(Filler filler, String queryName, CustomerService customerService, DrugService drugService, DrugTypeService drugTypeService) {
        super(filler, queryName);
        this.customerService = customerService;
        this.drugService = drugService;
        this.drugTypeService = drugTypeService;

        drugComboBox = new DrugComboBox(true);
        drugTypeComboBox = new DrugTypeComboBox();
        dialogPanel = new DialogPanel(2);
        dialogPanel.addComponent("Лекарство", drugComboBox);
        dialogPanel.addComponent("Тип лекарства", drugTypeComboBox);
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
                drug != null ? drug.getId() : null,
                drugType != null ? drugType.getId() : null
        );
    }
}
