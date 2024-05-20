package ru.nsu.kondrenko.gui.view;

import javax.swing.*;

public interface View {
    void show();

    void showError(String errorMessage);

    void showNoConnectionError();

    boolean showConfirmationDialog(String title, JPanel content);
}
