package ru.nsu.kondrenko.gui.view.central;

import lombok.Getter;
import ru.nsu.kondrenko.gui.view.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CentralPanel extends JPanel {
    private static final String TABLE_CARD_NAME = "Table";
    private static final String ORDER_INFO_CARD_NAME = "Order-Info";
    private static final String DRUG_INFO_CARD_NAME = "Drug-Info";
    private static final String ORDER_CREATION_CARD_NAME = "Order-Creation";

    private final JPanel subPanel;

    @Getter
    private final QueryResultPanel queryResultPanel;

    @Getter
    private final DrugInfoPanel drugInfoPanel;

    @Getter
    private final OrderInfoPanel orderInfoPanel;

    @Getter
    private final OrderCreationForm orderCreationForm;

    private final CardLayout cardLayout;

    @Getter
    private final JLabel titleLabel;

    public CentralPanel(ActionListener confirmCreateOrderListener) {
        setLayout(new BorderLayout());

        titleLabel = new JLabel("", SwingConstants.CENTER);
        titleLabel.setFont(new Font(Constants.FONT_FAMILY, Font.PLAIN, 16));
        add(titleLabel, BorderLayout.NORTH);

        queryResultPanel = new QueryResultPanel();
        drugInfoPanel = new DrugInfoPanel();
        orderInfoPanel = new OrderInfoPanel();
        orderCreationForm = new OrderCreationForm(confirmCreateOrderListener);

        subPanel = new JPanel();
        subPanel.add(queryResultPanel);
        subPanel.add(drugInfoPanel);
        subPanel.add(orderInfoPanel);
        subPanel.add(orderCreationForm);

        cardLayout = new CardLayout();
        cardLayout.addLayoutComponent(queryResultPanel, TABLE_CARD_NAME);
        cardLayout.addLayoutComponent(drugInfoPanel, DRUG_INFO_CARD_NAME);
        cardLayout.addLayoutComponent(orderInfoPanel, ORDER_INFO_CARD_NAME);
        cardLayout.addLayoutComponent(orderCreationForm, ORDER_CREATION_CARD_NAME);
        subPanel.setLayout(cardLayout);

        add(subPanel, BorderLayout.CENTER);
    }

    public void showTable() {
        cardLayout.show(subPanel, TABLE_CARD_NAME);
    }

    public void showDrugInfo() {
        cardLayout.show(subPanel, DRUG_INFO_CARD_NAME);
    }

    public void showOrderInfo() {
        cardLayout.show(subPanel, ORDER_INFO_CARD_NAME);
    }

    public void showOrderCreationForm() {
        cardLayout.show(subPanel, ORDER_CREATION_CARD_NAME);
    }
}
