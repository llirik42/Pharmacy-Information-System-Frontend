package ru.nsu.kondrenko.gui.controller.choosers;

import org.jdesktop.swingx.JXDatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatePicker extends JXDatePicker {
    public DatePicker() {
        super();
        setDate(Calendar.getInstance().getTime());
        setFormats(new SimpleDateFormat("dd.MM.yyyy"));
    }
}
