package ru.nsu.kondrenko.gui.view.central;

import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.utils.input.AdministrationRouteComboBox;
import ru.nsu.kondrenko.gui.controller.utils.input.DatePicker;
import ru.nsu.kondrenko.gui.controller.utils.input.DrugComboBox;
import ru.nsu.kondrenko.gui.controller.utils.input.IntegerSpinner;
import ru.nsu.kondrenko.gui.view.Constants;
import ru.nsu.kondrenko.model.dto.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

    private final List<DrugComboBox> drugComboBoxes;
    private final List<IntegerSpinner> drugAmountSpinners;
    private final List<AdministrationRouteComboBox> administrationRouteComboBoxes;

    private final JPanel drugListPanel;

    @Setter
    private List<Drug> drugList;

    @Setter
    private List<AdministrationRoute> administrationRoutes;

    public OrderCreationForm(ActionListener actionListener) {
        customerFullNameField = new JTextField();
        customerPhoneField = new JTextField();
        customerAddressField = new JTextField();
        patientFullNameField = new JTextField();
        patientBirthDayPicker = new DatePicker();
        diagnosisField = new JTextField();
        doctorFullNameField = new JTextField();
        prescriptionDatePicker = new DatePicker();
        drugListPanel = new JPanel();
        drugComboBoxes = new ArrayList<>();
        drugAmountSpinners = new ArrayList<>();
        administrationRouteComboBoxes = new ArrayList<>();

        final Font valueFont = new Font(Constants.FONT_FAMILY, Font.PLAIN, 18);
        final Font buttonFont = new Font(Constants.FONT_FAMILY, Font.PLAIN, 20);

        customerFullNameField.setFont(valueFont);
        customerPhoneField.setFont(valueFont);
        customerAddressField.setFont(valueFont);
        patientFullNameField.setFont(valueFont);
        patientBirthDayPicker.setFont(valueFont);
        diagnosisField.setFont(valueFont);
        doctorFullNameField.setFont(valueFont);
        prescriptionDatePicker.setFont(valueFont);

        final GridBagLayout layout = new GridBagLayout();

        setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(50, 0, 0, 0);

        add(Utils.createAttributePanel("ФИО клиента", customerFullNameField), gbc);
        add(Utils.createAttributePanel("Номер телефона клиента", customerPhoneField), gbc);
        add(Utils.createAttributePanel("Адрес клиента", customerAddressField), gbc);

        add(Utils.createAttributePanel("ФИО больного", patientFullNameField), gbc);
        add(Utils.createAttributePanel("Дата рождения больного", patientBirthDayPicker), gbc);

        add(Utils.createAttributePanel("Диагноз", diagnosisField), gbc);
        add(Utils.createAttributePanel("Врач", doctorFullNameField), gbc);
        add(Utils.createAttributePanel("Дата выписки", prescriptionDatePicker), gbc);

        add(drugListPanel, gbc);

        final JButton removeDrugButton = new JButton("Удалить лекарство");
        final JButton createOrderButton = new JButton("Оформить заказ");
        final JButton addDrugButton = new JButton("Добавить лекарство");

        removeDrugButton.setFont(buttonFont);
        createOrderButton.setFont(buttonFont);
        addDrugButton.setFont(buttonFont);

        createOrderButton.addActionListener(actionListener);

        removeDrugButton.addActionListener(actionEvent -> {
            if (drugComboBoxes.isEmpty()) {
                return;
            }

            drugComboBoxes.remove(drugComboBoxes.size() - 1);
            administrationRouteComboBoxes.remove(administrationRouteComboBoxes.size() - 1);
            drugAmountSpinners.remove(drugAmountSpinners.size() - 1);

            drugListPanel.setLayout(new GridLayout(drugComboBoxes.size(), 1));
            drugListPanel.remove(drugListPanel.getComponentCount() - 1);
            drugListPanel.revalidate();
        });

        addDrugButton.addActionListener(actionEvent -> {
            final DrugComboBox drugComboBox = new DrugComboBox(false);
            final IntegerSpinner drugAmountSpinner = new IntegerSpinner(1, 100, 1);
            final AdministrationRouteComboBox administrationRouteComboBox = new AdministrationRouteComboBox();

            drugComboBox.setDrugList(drugList);
            administrationRouteComboBox.setAdministrationRoutes(administrationRoutes);

            drugComboBoxes.add(drugComboBox);
            administrationRouteComboBoxes.add(administrationRouteComboBox);
            drugAmountSpinners.add(drugAmountSpinner);

            final JPanel drugPanel = Utils.create3ComponentPanel(drugComboBox, drugAmountSpinner, administrationRouteComboBox);

            drugListPanel.setLayout(new GridLayout(drugComboBoxes.size(), 1));
            drugListPanel.add(drugPanel);

            drugListPanel.revalidate();

            final int width = drugListPanel.getWidth();
            final int size = width / 3;

            drugComboBox.setPreferredSize(new Dimension(size, 32));
            drugAmountSpinner.setPreferredSize(new Dimension(size, 32));
            administrationRouteComboBox.setPreferredSize(new Dimension(size, 32));
        });

        add(Utils.create3ComponentPanel(removeDrugButton, createOrderButton, addDrugButton), gbc);
    }

    public Customer getCustomer() {
        final String fullName = customerFullNameField.getText();
        final String phone = customerPhoneField.getText();
        final String address = customerAddressField.getText();

        return new Customer(
                0,  // Fictive
                fullName,
                phone,
                address
        );
    }

    public ShortPrescription getPrescription() {
        final List<ShortPrescriptionItem> items = new ArrayList<>();

        for (int i = 0; i < drugComboBoxes.size(); i++) {
            final Drug drug = drugComboBoxes.get(i).getSelectedDrug();
            final int drugAmount = drugAmountSpinners.get(i).getIntValue();
            final AdministrationRoute route = administrationRouteComboBoxes.get(i).getSelectedRoute();

            items.add(new ShortPrescriptionItem(
                    drug.getId(),
                    drugAmount,
                    route.getId()
            ));
        }

        return new ShortPrescription(
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
                items
        );
    }
}
