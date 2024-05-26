package ru.nsu.kondrenko.gui.view.central;

import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.utils.input.DatePicker;
import ru.nsu.kondrenko.model.dto.*;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.util.List;

public class OrderCreationForm extends JPanel {
    private final JTextField customerFullNameField;
    private final JTextField customerPhoneField;
    private final JTextField customerAddressField;
    private final JTextField patientFullNameField;
    private final DatePicker patientBirthDayPicker;
    private final JTextField diagnosisField;
    private final JTextField doctorFullNameField;
    private final DatePicker prescriptionDatePicker;

    @Setter
    private List<Drug> drugList;

    @Setter
    private List<AdministrationRoute> adminitrationRoutes;

    public OrderCreationForm(ActionListener actionListener) {
        customerFullNameField = new JTextField();
        customerPhoneField = new JTextField();
        customerAddressField = new JTextField();
        patientFullNameField = new JTextField();
        patientBirthDayPicker = new DatePicker();
        diagnosisField = new JTextField();
        doctorFullNameField = new JTextField();
        prescriptionDatePicker = new DatePicker();

        final GridBagLayout layout = new GridBagLayout();

        setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(50, 0, 0, 0);

        add(new JLabel("Клиент"));
        add(Utils.createAttributePanel("ФИО", customerFullNameField), gbc);
        add(Utils.createAttributePanel("Номер телефона", customerPhoneField), gbc);
        add(Utils.createAttributePanel("Адрес", customerAddressField), gbc);

        add(new JLabel("Больной>"));
        add(Utils.createAttributePanel("Больной, ФИО", patientFullNameField), gbc);
        add(Utils.createAttributePanel("Больной, дата рождения", patientBirthDayPicker), gbc);

        add(new Label("Рецепт"));
        add(Utils.createAttributePanel("Диагноз", diagnosisField), gbc);
        add(Utils.createAttributePanel("Врач", doctorFullNameField), gbc);
        add(Utils.createAttributePanel("Дата выписки", prescriptionDatePicker), gbc);

        add(new Label("Медикаменты"));
        final JButton createOrderButton = new JButton("Оформить заказ");
        createOrderButton.addActionListener(actionListener);
        add(createOrderButton, gbc);
    }

    public Customer getCustomer() {
        final String fullName = customerFullNameField.getText();
        final String phone = customerPhoneField.getText();
        final String address = customerAddressField.getText();

        if (fullName.isBlank() || phone.isBlank() || address.isBlank()) {
            return null;
        }

        return new Customer(
                0,  // Fictive
                fullName,
                phone,
                address
        );
    }

    public Prescription getPrescription() {
        return new Prescription(
                0, // Fictive
                diagnosisField.getText(),
                new Patient(
                        0, // Fictive
                        patientFullNameField.getText(),
                        patientBirthDayPicker.getDate()
                ),
                new Doctor(
                        0, // Fictive
                        doctorFullNameField.getText()
                ),
                prescriptionDatePicker.getDate(),
                List.of()
        );
    }
}
