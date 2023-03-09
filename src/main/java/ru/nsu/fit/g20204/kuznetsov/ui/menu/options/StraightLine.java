package ru.nsu.fit.g20204.kuznetsov.ui.menu.options;


import ru.nsu.fit.g20204.kuznetsov.ui.content.buttons.instruments.LineButton;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

public class StraightLine extends JMenuItem {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public StraightLine() {
        super("Straight line");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (LineButton.getInstance() != null) {
                    LineButton.getInstance().doClick();

                    logger.info("clicked");
                } else {
                    logger.info("null");
                }
            }
        });
    }
}
