package ru.nsu.fit.g20204.kuznetsov.controllers;


import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.ui.content.DrawingArea;

import java.awt.*;

public class PencilController implements Controller {
    protected static Point startPoint = new Point(0, 0);
    protected static Point finishPoint = new Point(0, 0);
    protected static boolean show = false;

    public static void control() {

    }

    public static void beginControl(Point location) {
        startPoint = finishPoint;
        finishPoint = location;
    }

    public static void finishControl(Point location) {
        startPoint = finishPoint;
        finishPoint = location;
        show = false;
    }

    public static void paint(Graphics g) {
        if (show) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Hand.getColor());
            g2.setStroke(new BasicStroke(Hand.getWidth()));
            g2.drawLine(startPoint.x, startPoint.y, finishPoint.x, finishPoint.y);
        }
    }

    public static void mediumControl(Point location) {
        show = true;
        startPoint = finishPoint;
        finishPoint = location;
        DrawingArea.takeSnapshot();
    }
}
