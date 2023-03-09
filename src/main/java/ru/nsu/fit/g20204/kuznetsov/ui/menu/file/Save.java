package ru.nsu.fit.g20204.kuznetsov.ui.menu.file;

import ru.nsu.fit.egork.History;
import ru.nsu.fit.egork.ui.MainFrame;

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
                if (History.getPath() == null) {
                    var saveChooser = new JFileChooser();
                    saveChooser.showDialog(MainFrame.getInstance(), "Save");
                    saveChooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
                    History.setPath(saveChooser.getSelectedFile().getPath());
                }

                if (!History.getScreens().isEmpty()) {
                    try {
                        ImageIO.write(History.getLastScreen(), History.getFormat(), new File(History.getPath()));
                        logger.info("Saved: " + History.getPath());
                    } catch (IOException ex) {
                        logger.info("Cannot save in png format");
                    }
                }
            }
        });
    }
}
