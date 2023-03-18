package ru.nsu.fit.g20204.kuznetsov.ui.menu.draw.stamps;

import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.stamps.StampsButtonGroup;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StampMenuItem extends JMenuItem {

    public StampMenuItem(StampType type) {
        super(type.name());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                StampsButtonGroup.doClick(type);
            }
        });
    }
}
