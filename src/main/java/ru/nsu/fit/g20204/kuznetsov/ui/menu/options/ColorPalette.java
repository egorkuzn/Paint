package ru.nsu.fit.g20204.kuznetsov.ui.menu.options;

import ru.nsu.fit.g20204.kuznetsov.ui.buttons.instruments.ColorChooseButton;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

public class ColorPalette extends JMenuItem {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public ColorPalette() {
        super("Color palette");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (ColorChooseButton.getInstance(0, 0) != null) {
                    ColorChooseButton.getInstance(0, 0).doClick();

                    logger.info("clicked");
                } else {
                    logger.info("null");
                }
            }
        });
    }
}
