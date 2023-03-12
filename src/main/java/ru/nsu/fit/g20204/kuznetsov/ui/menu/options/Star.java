package ru.nsu.fit.g20204.kuznetsov.ui.menu.options;


import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.stamps.StampsButtonGroup;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

public class Star extends JMenuItem {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Star() {
        super("Star");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                StampsButtonGroup.doClick(StampType.STAR);
                logger.info("clicked");
            }
        });
    }
}
