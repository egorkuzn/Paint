package ru.nsu.fit.g20204.kuznetsov.ui.menu.options;


import ru.nsu.fit.g20204.kuznetsov.ui.menu.options.*;

import javax.swing.*;

public class Options extends JMenu {
    public Options() {
        super("Options");
        add(new StraightLine());
        add(new Eraser());
        add(new Fill());
        add(new ColorPalette());
        addSeparator();
        add(new Polygon());
        add(new Star());
    }
}
