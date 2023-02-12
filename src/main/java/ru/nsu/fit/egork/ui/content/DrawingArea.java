package ru.nsu.fit.egork.ui.content;

import javax.swing.*;
import java.awt.*;

public class DrawingArea extends JPanel {
    private static DrawingArea drawingArea = null;
    private DrawingArea() {
        super(new BorderLayout());
    }

    public static DrawingArea getInstance() {
        if (drawingArea == null) {
            drawingArea = new DrawingArea();
        }

        return drawingArea;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(4));
        g2.drawLine(0, 0, getWidth()-1, getHeight()-1);
    }
}
