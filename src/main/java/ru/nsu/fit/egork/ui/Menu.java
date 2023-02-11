package ru.nsu.fit.egork.ui;

import ru.nsu.fit.egork.ui.menus.File;
import ru.nsu.fit.egork.ui.menus.Help;
import ru.nsu.fit.egork.ui.menus.View;

import javax.swing.*;

public class Menu {
    public static JMenuBar getBar() {
        var file = new File();
        var view = new View();
        var help = new Help();

        var menuBar = new JMenuBar();

        menuBar.add(file);
        menuBar.add(view);
        menuBar.add(help);

        return menuBar;
    }
}
