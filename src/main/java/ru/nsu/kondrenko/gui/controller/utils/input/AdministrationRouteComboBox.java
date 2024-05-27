package ru.nsu.kondrenko.gui.controller.utils.input;

import ru.nsu.kondrenko.model.dto.AdministrationRoute;

import javax.swing.*;
import java.util.List;

public class AdministrationRouteComboBox extends JComboBox<String> {
    private List<AdministrationRoute> routes;

    public void setAdministrationRoutes(List<AdministrationRoute> routes) {
        this.routes = routes;
        changeModel();
    }

    public AdministrationRoute getSelectedRoute() {
        return routes.get(getSelectedIndex());
    }

    private void changeModel() {
        final String[] routeNames = new String[routes.size()];

        for (int i = 0; i < routes.size(); i++) {
            final AdministrationRoute route = this.routes.get(i);
            routeNames[i] = route.getDescription();
        }

        setModel(new DefaultComboBoxModel<>(routeNames));
    }
}
