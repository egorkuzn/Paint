package ru.nsu.fit.g20204.kuznetsov.ui.menu.file;


import ru.nsu.fit.g20204.kuznetsov.util.FileExplorer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

public class Open extends JMenuItem {
    public static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Open() {
        super("Open");
        logger.info("'Open' pressed");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                FileExplorer.openFile();
            }
        });
    }
}
