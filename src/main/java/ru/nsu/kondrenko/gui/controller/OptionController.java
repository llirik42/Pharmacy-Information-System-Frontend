package ru.nsu.kondrenko.gui.controller;

import lombok.Getter;
import lombok.Setter;
import ru.nsu.kondrenko.gui.View;
import ru.nsu.kondrenko.model.Context;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public abstract class OptionController implements ActionListener {
    private final String optionName;

    @Setter
    private View view;

    @Setter
    private JLabel titleLabel;

    @Setter
    private Context context;

    public OptionController(String optionName) {
        this.optionName = optionName;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setLabel();
    }

    protected void setLabel() {
        titleLabel.setText(optionName);
    }
}
