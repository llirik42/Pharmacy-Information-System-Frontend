package ru.nsu.kondrenko.gui.view;

import javax.swing.*;

public interface View {
    void show();

    void showError(String errorMessage);

    void showInfo(String infoMessage);

    void showNoConnectionError();

    void showEmptyResultInfo();

    boolean showConfirmationDialog(String title, JPanel content);
}
