package ru.nsu.kondrenko.gui;

import javax.swing.*;

public interface View {
    void show();

    void showError(String errorMessage);

    void showInfo(String infoMessage);

    void showNoConnectionError();

    boolean showConfirmationDialog(String title, JPanel content);

    void showTable();

    void showDrugInfo();

    void showOrderInfo();

    void showOrderCreationForm();
}
