package ru.nsu.kondrenko.gui.controller.queries;

import lombok.Getter;
import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.fillers.Filler;
import ru.nsu.kondrenko.gui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public abstract class QueryController implements ActionListener {
    private final Filler filler;

    private final String queryName;

    @Getter
    @Setter
    private View view;

    @Setter
    private JTable table;

    public QueryController(Filler filler, String queryName) {
        this.filler = filler;
        this.queryName = queryName;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            final List<?> result = getResult();

            if (result != null) {
                fillTable(result);
            }
        } catch (Exception exception) {
            view.showNoConnectionError();
        }
    }

    protected abstract List<?> getResult() throws Exception;

    protected String getNotFoundMessage() {
        return String.format("%s не найдены", queryName);
    }

    private void fillTable(List<?> result) {
        filler.fillTable(table, result.toArray());

        if (result.isEmpty()) {
            view.showInfo(getNotFoundMessage());
        }
    }
}
