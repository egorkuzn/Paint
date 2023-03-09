package ru.nsu.fit.g20204.kuznetsov.ui.menu;


import ru.nsu.fit.g20204.kuznetsov.ui.menu.file.*;

import javax.swing.*;

public class File extends JMenu {
    public File() {
        super("File");
        add(new New());
        add(new Open());
        add(new Save());
        add(new SaveAs());
    }
}
