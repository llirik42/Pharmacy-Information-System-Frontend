package ru.nsu.kondrenko.gui.controller.queries;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.dto.ProductionComponent;
import ru.nsu.kondrenko.model.services.production.ProductionService;
import ru.nsu.kondrenko.model.services.production.exceptions.ProductionServiceException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@RequiredArgsConstructor
public class ProductionComponentsController implements ActionListener {
    private final ProductionService productionService;

    private final Filler filler;

    @Setter
    private View view;

    @Setter
    private JTable table;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            final List<ProductionComponent> productionComponents = productionService.getProductionComponents();
            filler.fillTable(table, productionComponents.toArray());

            if (productionComponents.isEmpty()) {
                view.showInfo("Медикаменты, требуемые для производства, не найдены");
            }
        } catch (ProductionServiceException ignored) {
            view.showNoConnectionError();
        }
    }
}
