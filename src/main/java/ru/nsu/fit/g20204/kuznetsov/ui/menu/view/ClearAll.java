package ru.nsu.fit.g20204.kuznetsov.ui.menu.view;

import ru.nsu.fit.g20204.kuznetsov.History;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class ClearAll extends JMenuItem {
    public ClearAll() {
        super("Clear all");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                var buffer = new BufferedImage(History.getMaxWidth(),
                        History.getMaxHeight(),
                        BufferedImage.TYPE_INT_RGB);

                Graphics2D g2 = (Graphics2D) buffer.getGraphics();
                g2.setColor(Color.WHITE);
                g2.fillRect(0, 0, History.getMaxWidth(), History.getMaxHeight());

                History.saveScreen(buffer);
            }
        });
    }
}
