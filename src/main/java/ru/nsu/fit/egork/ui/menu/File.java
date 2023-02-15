package ru.nsu.fit.egork.ui.menu;

import ru.nsu.fit.egork.ui.menu.file.New;
import ru.nsu.fit.egork.ui.menu.file.Open;
import ru.nsu.fit.egork.ui.menu.file.Save;
import ru.nsu.fit.egork.ui.menu.file.SaveAs;

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
