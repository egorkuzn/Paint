package ru.nsu.fit.g20204.kuznetsov.ui.menu;

import ru.nsu.fit.egork.ui.menu.help.About;
import ru.nsu.fit.egork.ui.menu.help.Instruction;

import javax.swing.*;

public class Help extends JMenu {
    public Help() {
        super("Help");
        add(new Instruction());
        add(new About());
    }
}
