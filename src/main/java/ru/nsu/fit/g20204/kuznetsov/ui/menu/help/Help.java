package ru.nsu.fit.g20204.kuznetsov.ui.menu.help;

import ru.nsu.fit.g20204.kuznetsov.ui.menu.help.*;

import javax.swing.*;

public class Help extends JMenu {
    public Help() {
        super("Help");
        add(new Instruction());
        add(new About());
    }
}
