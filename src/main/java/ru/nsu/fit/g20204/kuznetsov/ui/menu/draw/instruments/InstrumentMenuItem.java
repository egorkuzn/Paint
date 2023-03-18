package ru.nsu.fit.g20204.kuznetsov.ui.menu.draw.instruments;

import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InstrumentMenuItem extends JMenuItem {
    public InstrumentMenuItem(ToolButton toolButton) {
        super(toolButton.getName());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                toolButton.doClick();
            }
        });
    }
}
