package ru.nsu.fit.g20204.kuznetsov.ui.menu.file;

import ru.nsu.fit.g20204.kuznetsov.History;
import ru.nsu.fit.g20204.kuznetsov.ui.MainFrame;
import ru.nsu.fit.g20204.kuznetsov.util.FileExplorer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Save extends JMenuItem {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Save() {
        super("Save");

        logger.info("'Save' pressed");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                FileExplorer.saveFile();
            }
        });
    }
}
