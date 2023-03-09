package ru.nsu.fit.g20204.kuznetsov.ui.menu.file;

import ru.nsu.fit.egork.History;
import ru.nsu.fit.egork.ui.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Open extends JMenuItem {
    public static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Open() {
        super("Open");
        logger.info("'Open' pressed");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                var saveChooser = new JFileChooser();
                saveChooser.showDialog(MainFrame.getInstance(), "Open");
                saveChooser.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
                History.setPath(saveChooser.getSelectedFile().getPath());

                try {
                    History.saveScreen(ImageIO.read(new File(History.getPath())));
                } catch (IllegalArgumentException | IOException ex) {
                    logger.warning("Cannot read chosen image");
                }
            }
        });
    }
}
