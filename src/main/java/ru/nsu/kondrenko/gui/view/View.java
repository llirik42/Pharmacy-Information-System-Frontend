package ru.nsu.kondrenko.gui.view;

public interface View {
    void show();

    void showError(String errorMessage);

    void showNoConnectionError();
}
