package ru.nsu.fit.egork.ui.menu;

import ru.nsu.fit.egork.ui.menu.view.ClearAll;

import javax.swing.*;

public class View extends JMenu {
    public View() {
        super("View");
        add(new ClearAll());
    }
}
