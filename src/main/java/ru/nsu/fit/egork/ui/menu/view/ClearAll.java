package ru.nsu.fit.egork.ui.menu.view;

import ru.nsu.fit.egork.History;
import ru.nsu.fit.egork.ui.content.DrawingArea;

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
                var buffer = new BufferedImage(DrawingArea.getInstance().getWidth(),
                        DrawingArea.getInstance().getHeight(),
                        BufferedImage.TYPE_INT_RGB);

                Graphics2D g2 = (Graphics2D) buffer.getGraphics();
                g2.setColor(Color.WHITE);
                g2.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());

                History.saveScreen(buffer);
            }
        });
    }
}
