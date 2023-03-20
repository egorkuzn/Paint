package ru.nsu.fit.g20204.kuznetsov.util;

import ru.nsu.fit.g20204.kuznetsov.History;
import ru.nsu.fit.g20204.kuznetsov.ui.MainFrame;
import ru.nsu.fit.g20204.kuznetsov.ui.content.DrawingArea;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class FileExplorer {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void openFile() {
        var saveChooser = new JFileChooser();
        saveChooser.showDialog(null, "Open");
        saveChooser.setFileSelectionMode(JFileChooser.OPEN_DIALOG);

        if (saveChooser.getSelectedFile() != null) {
            var path = saveChooser.getSelectedFile().getPath();

            if (path.substring(path.lastIndexOf(".") + 1).matches("png|jpg|jpeg|bmp|gif")) {
                DrawingArea.getInstance().update();
                History.setPath(path);
            } else {
                JOptionPane.showMessageDialog(MainFrame.getInstance(),
                        """
                                   File format isn't valid.
                                   Your file is %s.
                                   Open another image .png, .jpg, .jpeg, .bmp or .gif type.
                                   """.formatted(path),
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        try {
            if (History.getPath() != null) {
                var image = ImageIO.read(new File(History.getPath()));

                if (image != null) {
                    History.setMaxHeight(image.getHeight());
                    History.setMaxWidth(image.getWidth());
                    History.saveScreen(image);
                    DrawingArea.getInstance().revalidate();
                } else {
                    JOptionPane.showMessageDialog(MainFrame.getInstance(),
                            "Cannot open this file. Please choose another one.",
                            "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IllegalArgumentException | IOException ex) {
            logger.warning("Cannot read chosen image");
        }
    }

    public static void saveFile() {
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
}
