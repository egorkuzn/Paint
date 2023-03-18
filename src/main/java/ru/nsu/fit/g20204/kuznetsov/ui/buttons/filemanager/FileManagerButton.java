package ru.nsu.fit.g20204.kuznetsov.ui.buttons.filemanager;

import ru.nsu.fit.g20204.kuznetsov.History;
import ru.nsu.fit.g20204.kuznetsov.ui.MainFrame;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class FileManagerButton extends ToolButton {
    public FileManagerButton() {
        super("tools/files.png",
                "Open new file");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                var saveChooser = new JFileChooser();
                saveChooser.showDialog(MainFrame.getInstance(), "Open");
                saveChooser.setFileSelectionMode(JFileChooser.OPEN_DIALOG);

                if (saveChooser.getSelectedFile() != null) {
                    History.setPath(saveChooser.getSelectedFile().getPath());
                }

                try {
                    if (History.getPath() != null) {
                        History.saveScreen(ImageIO.read(new File(History.getPath())));
                    }
                } catch (IllegalArgumentException | IOException ex) {
                    logger.warning("Cannot read chosen image");
                }
            }
        });
    }
}
