package ru.nsu.fit.g20204.kuznetsov.ui.menu.options;

import ru.nsu.fit.egork.ui.content.buttons.instruments.FillerButton;
import ru.nsu.fit.egork.ui.content.buttons.instruments.LineButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

public class Fill extends JMenuItem {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Fill() {
        super("Fill");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (FillerButton.getInstance(0, 0) != null) {
                    FillerButton.getInstance(0, 0).doClick();

                    logger.info("clicked");
                } else {
                    logger.info("null");
                }
            }
        });
    }
}