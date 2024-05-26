package ru.nsu.kondrenko.gui.view.central;

import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.dto.Order;
import ru.nsu.kondrenko.model.dto.PrescriptionItem;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderInfoPanel extends InfoPanel {
    private final JLabel idLabel;
    private final JLabel registrationLabel;
    private final JLabel appointedLabel;
    private final JLabel obtainingLabel;
    private final JLabel isPaidLabel;
    private final JLabel customerLabel;
    private final JLabel drugsLabel;

    private final SimpleDateFormat simpleDateFormat;

    public OrderInfoPanel() {
        super(7);

        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy        HH:mm");

        idLabel = Utils.createAttributeValueLabel();
        registrationLabel = Utils.createAttributeValueLabel();
        appointedLabel = Utils.createAttributeValueLabel();
        obtainingLabel = Utils.createAttributeValueLabel();
        isPaidLabel = Utils.createAttributeValueLabel();
        customerLabel = Utils.createAttributeValueLabel();
        drugsLabel = Utils.createAttributeValueLabel();

        add(Utils.createAttributePanel("Номер", idLabel));
        add(Utils.createAttributePanel("Дата создания", registrationLabel));
        add(Utils.createAttributePanel("Назначенная дата получения", appointedLabel));
        add(Utils.createAttributePanel("Дата получения", obtainingLabel));
        add(Utils.createAttributePanel("Оплачен", isPaidLabel));
        add(Utils.createAttributePanel("Клиент", customerLabel));
        add(Utils.createAttributePanel("Состав", drugsLabel));
    }

    public void update(Order order) {
        idLabel.setText(Integer.toString(order.getId()));
        registrationLabel.setText(datetimeToString(order.getRegistrationDatetime()));
        appointedLabel.setText(datetimeToString(order.getAppointedDatetime()));
        obtainingLabel.setText(datetimeToString(order.getObtainingDatetime()));
        isPaidLabel.setText(Utils.booleanAttributeToString(order.isPaid()));
        customerLabel.setText(Utils.customerToString(order.getCustomer()));
        drugsLabel.setText(orderItemsToString(order.getPrescription().getItems()));
    }

    private String datetimeToString(Date date) {
        if (date == null) {
            return "";
        }

        return simpleDateFormat.format(date);
    }

    private String orderItemsToString(List<PrescriptionItem> items) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < items.size(); i++) {
            final PrescriptionItem item = items.get(i);
            final Drug drug = item.getDrug();

            result.append("%s (%s)".formatted(
                    drug.getName(),
                    item.getDrugAmount()
            ));

            if (i != items.size() - 1) {
                result.append("    ");
            }
        }

        return result.toString();
    }
}
