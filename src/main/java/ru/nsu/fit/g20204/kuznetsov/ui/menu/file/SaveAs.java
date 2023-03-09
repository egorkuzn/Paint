package ru.nsu.fit.g20204.kuznetsov.ui.menu.file;

import ru.nsu.fit.g20204.kuznetsov.History;
import ru.nsu.fit.g20204.kuznetsov.ui.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class SaveAs extends JMenuItem {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public SaveAs() {
        super("Save as");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                logger.info("'Save as' pressed");

                var saveChooser = new JFileChooser();
                saveChooser.showDialog(MainFrame.getInstance(), "Save");
                saveChooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);


                if (!History.getScreens().isEmpty()) {
                    try {
                        History.setPath(saveChooser.getSelectedFile().getPath());
                        ImageIO.write(History.getLastScreen(), "png", new File(History.getPath()));
                        logger.info("Saved: " + saveChooser.getSelectedFile().getPath());
                    } catch (IOException ex) {
                        logger.info("Cannot save in png format");
                    }
                }
            }
        });
    }
}
