package ru.nsu.fit.g20204.kuznetsov.ui.menu.view;

import ru.nsu.fit.g20204.kuznetsov.ui.menu.view.ClearAll;

import javax.swing.*;

public class View extends JMenu {
    public View() {
        super("View");
        add(new ClearAll());
    }
}
