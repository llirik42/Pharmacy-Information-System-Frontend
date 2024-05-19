package ru.nsu.kondrenko.gui.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OptionsPanel extends JPanel {
    public OptionsPanel(ActionListener createOrderListener,
                        ActionListener payOrderListener,
                        ActionListener obtainOrderListener,
                        ActionListener drugsListener,
                        ActionListener ordersListener,
                        ActionListener forgottenOrdersListener,
                        ActionListener productionOrdersListener,
                        ActionListener waitingCustomersListener,
                        ActionListener frequentCustomersListener,
                        ActionListener orderedSomethingCustomersListener,
                        ActionListener popularDrugsListener,
                        ActionListener usedDrugsListener,
                        ActionListener criticalAmountDrugsListener,
                        ActionListener productionComponentsListener,
                        ActionListener minimalAmountDrugsListener,
                        ActionListener technologiesListener) {
        setPreferredSize(new Dimension(350, -1));

        add(new Option("Создать заказ", createOrderListener));
        add(new Option("Оплатить заказ", payOrderListener));
        add(new Option("Забрать заказ", obtainOrderListener));
        add(new Option("Информация о заказе", null));
        add(new Option("Все заказы", ordersListener));
        add(new Option("Информация о медикаменте", null));
        add(new Option("Все медикаменты", drugsListener));
        add(new Option("Забытые заказы", forgottenOrdersListener));
        add(new Option("Заказы в производстве", productionOrdersListener));
        add(new Option("Ждущие клиенты", waitingCustomersListener));
        add(new Option("Постоянные клиенты", frequentCustomersListener));
        add(new Option("Клиенты, заказавшие медикаменты", orderedSomethingCustomersListener));
        add(new Option("Популярные медикаменты", popularDrugsListener));
        add(new Option("Использованные медикаменты", usedDrugsListener));
        add(new Option("Медикаменты с критической нормой/закончившиеся", criticalAmountDrugsListener));
        add(new Option("Требуемые для производства медикаменты", productionComponentsListener));
        add(new Option("Медикаменты с минимальным запасом", minimalAmountDrugsListener));
        add(new Option("Все технологии", technologiesListener));
    }
}
