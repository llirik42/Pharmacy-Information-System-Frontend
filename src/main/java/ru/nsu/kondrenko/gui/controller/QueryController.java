package ru.nsu.kondrenko.gui.controller;

import lombok.Setter;
import ru.nsu.kondrenko.gui.controller.utils.fillers.Filler;
import ru.nsu.kondrenko.gui.view.central.QueryResultPanel;

import java.awt.event.ActionEvent;
import java.util.List;

public abstract class QueryController extends OptionController {
    private final Filler filler;

    @Setter
    private QueryResultPanel queryResultPanel;

    public QueryController(Filler filler, String queryName) {
        super(queryName);
        this.filler = filler;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            final List<?> result = getResult();

            if (result != null) {
                fillTable(result);
            }
        } catch (Exception exception) {
            getView().showNoConnectionError();
        }
    }

    protected abstract List<?> getResult() throws Exception;

    protected String getNotFoundMessage() {
        return String.format("%s не найдены", getOptionName());
    }

    private void fillTable(List<?> result) {
        filler.fillTable(queryResultPanel.getTable(), result.toArray());
        setLabel();
        getView().showTable();

        if (result.isEmpty()) {
            getView().showInfo(getNotFoundMessage());
        }
    }
}
