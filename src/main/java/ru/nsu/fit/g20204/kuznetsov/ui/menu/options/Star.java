package ru.nsu.fit.g20204.kuznetsov.ui.menu.options;

import ru.nsu.fit.egork.instruments.StampType;
import ru.nsu.fit.egork.ui.content.buttons.instruments.ColorChooseButton;
import ru.nsu.fit.egork.ui.content.buttons.instruments.LineButton;
import ru.nsu.fit.egork.ui.content.buttons.stamps.StampsButtonGroup;

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
