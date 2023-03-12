package ru.nsu.fit.g20204.kuznetsov.ui.menu;

import ru.nsu.fit.g20204.kuznetsov.ui.menu.file.File;
import ru.nsu.fit.g20204.kuznetsov.ui.menu.help.Help;
import ru.nsu.fit.g20204.kuznetsov.ui.menu.options.Options;
import ru.nsu.fit.g20204.kuznetsov.ui.menu.undoredo.Redo;
import ru.nsu.fit.g20204.kuznetsov.ui.menu.undoredo.Undo;
import ru.nsu.fit.g20204.kuznetsov.ui.menu.view.View;

import javax.swing.*;

public class Menu {
    public static JMenuBar getBar() {
        var menuBar = new JMenuBar();

        menuBar.add(new File());
        menuBar.add(new Options());
        menuBar.add(new View());
        menuBar.add(new Help());
        menuBar.add(Undo.getInstance());
        menuBar.add(Redo.getInstance());

        return menuBar;
    }
}
