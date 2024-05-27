package ru.nsu.kondrenko.gui.controller.options;

import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.OptionController;
import ru.nsu.kondrenko.gui.view.central.OrderCreationForm;
import ru.nsu.kondrenko.model.services.administration_routes.AdministrationRouteService;
import ru.nsu.kondrenko.model.services.administration_routes.exceptions.AdministrationServiceException;
import ru.nsu.kondrenko.model.services.drugs.DrugService;
import ru.nsu.kondrenko.model.services.drugs.exceptions.DrugServiceException;

import java.awt.event.ActionEvent;

public class CreateOrderController extends OptionController {
    private final DrugService drugService;
    private final AdministrationRouteService administrationRouteService;

    @Setter
    private OrderCreationForm orderCreationForm;

    public CreateOrderController(String optionName, DrugService drugService, AdministrationRouteService administrationRouteService) {
        super(optionName);
        this.drugService = drugService;
        this.administrationRouteService = administrationRouteService;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            orderCreationForm.setDrugList(drugService.getDrugs());
            orderCreationForm.setAdministrationRoutes(administrationRouteService.getAdministrationRoutes());
            setLabel();
            getView().showOrderCreationForm();
        } catch (DrugServiceException | AdministrationServiceException exception) {
            getView().showNoConnectionError();
        }
    }
}
