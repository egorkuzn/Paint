package ru.nsu.fit.g20204.kuznetsov.ui.menu.draw.stamps;

import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;

import javax.swing.*;

public class StampsMenu extends JMenu {
    public StampsMenu() {
        super("Stamps");

        for(StampType type: StampType.values())
            add(new StampMenuItem(type));
    }
}
