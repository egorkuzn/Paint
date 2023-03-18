package ru.nsu.fit.g20204.kuznetsov.ui.menu.draw;

import ru.nsu.fit.g20204.kuznetsov.ui.menu.draw.instruments.InstrumentsMenu;
import ru.nsu.fit.g20204.kuznetsov.ui.menu.draw.stamps.StampsMenu;

import javax.swing.*;

public class DrawMenu extends JMenu {
    public DrawMenu() {
        super("Draw");

        add(new InstrumentsMenu());
        add(new StampsMenu());
    }
}
