package ru.nsu.kondrenko.gui.controller.options;

import lombok.Setter;
import org.jdesktop.swingx.JXDatePicker;
import ru.nsu.kondrenko.gui.controller.fillers.TableFiller;
import ru.nsu.kondrenko.gui.view.Utils;
import ru.nsu.kondrenko.gui.view.View;
import ru.nsu.kondrenko.model.dto.UsedDrug;
import ru.nsu.kondrenko.model.services.drugs.DrugService;
import ru.nsu.kondrenko.model.services.drugs.exceptions.DrugServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class UsedDrugsController implements ActionListener {
    private final DrugService drugService;

    private final TableFiller filler;

    private final JPanel dialogPanel;

    private final JXDatePicker startDatePicker;
    private final JXDatePicker endDatePicker;

    @Setter
    private View view;

    @Setter
    private JTable table;

    public UsedDrugsController(DrugService drugService, TableFiller filler) {
        this.drugService = drugService;
        this.filler = filler;
        startDatePicker = createDatePicker();
        endDatePicker = createDatePicker();
        dialogPanel = Utils.createDialogPanel(2);
        Utils.addComponentToPanel(dialogPanel, "Начальная дата", startDatePicker);
        Utils.addComponentToPanel(dialogPanel, "Конечная дата", endDatePicker);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        final boolean ok = view.showConfirmationDialog("Название", dialogPanel);
        if (!ok) {
            return;
        }

        try {
            final List<UsedDrug> usedDrugs = drugService.getUsedDrugs(
                    startDatePicker.getDate(),
                    endDatePicker.getDate()
            );
            filler.fillTable(table, usedDrugs.toArray());

            if (usedDrugs.isEmpty()) {
                view.showInfo("Использованные медикаменты не найдены");
            }
        } catch (DrugServiceException ignored) {
            view.showNoConnectionError();
        }
    }

    private static JXDatePicker createDatePicker() {
        final JXDatePicker datePicker = new JXDatePicker();
        resetDatePicker(datePicker);
        datePicker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        return datePicker;
    }

    private static void resetDatePicker(JXDatePicker datePicker) {
        datePicker.setDate(Calendar.getInstance().getTime());
    }
}
