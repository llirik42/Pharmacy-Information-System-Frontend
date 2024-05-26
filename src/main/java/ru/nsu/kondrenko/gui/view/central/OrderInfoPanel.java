package ru.nsu.kondrenko.gui.view.central;

import ru.nsu.kondrenko.model.dto.Order;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderInfoPanel extends InfoPanel {
    private final JLabel idLabel;
    private final JLabel registrationLabel;
    private final JLabel appointedLabel;
    private final JLabel obtainingLabel;
    private final JLabel isPaidLabel;
    private final JLabel customerLabel;

    private final SimpleDateFormat simpleDateFormat;

    public OrderInfoPanel() {
        super(6);

        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy        HH:mm");

        idLabel = Utils.createAttributeValueLabel();
        registrationLabel = Utils.createAttributeValueLabel();
        appointedLabel = Utils.createAttributeValueLabel();
        obtainingLabel = Utils.createAttributeValueLabel();
        isPaidLabel = Utils.createAttributeValueLabel();
        customerLabel = Utils.createAttributeValueLabel();

        add(Utils.createAttributePanel("Номер", idLabel));
        add(Utils.createAttributePanel("Дата создания", registrationLabel));
        add(Utils.createAttributePanel("Назначенная дата получения", appointedLabel));
        add(Utils.createAttributePanel("Дата получения", obtainingLabel));
        add(Utils.createAttributePanel("Оплачен", isPaidLabel));
        add(Utils.createAttributePanel("Клиент", customerLabel));
    }

    public void update(Order order) {
        idLabel.setText(Integer.toString(order.getId()));
        registrationLabel.setText(datetimeToString(order.getRegistrationDatetime()));
        appointedLabel.setText(datetimeToString(order.getAppointedDatetime()));
        obtainingLabel.setText(datetimeToString(order.getObtainingDatetime()));
        isPaidLabel.setText(Utils.booleanAttributeToString(order.isPaid()));
        customerLabel.setText(Utils.customerToString(order.getCustomer()));
    }

    private String datetimeToString(Date date) {
        if (date == null) {
            return "";
        }

        return simpleDateFormat.format(date);
    }
}
