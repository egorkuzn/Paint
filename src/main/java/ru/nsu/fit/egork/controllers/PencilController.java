package ru.nsu.fit.egork.controllers;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.ui.content.DrawingArea;

import java.awt.*;

public class PencilController implements Controller{
    private static Point startPoint = new Point(0, 0);
    private static Point finishPoint = new Point(0, 0);

    public static void control() {

    }

    public static void beginControl(Point location) {
        startPoint = finishPoint;
        finishPoint = location;
    }

    public static void finishControl(Point location) {
        startPoint = finishPoint;
        finishPoint = location;
    }

    public static void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Hand.getColor());
        g2.setStroke(new BasicStroke(Hand.getWidth()));
        g2.drawLine(startPoint.x,
                startPoint.y,
                finishPoint.x,
                finishPoint.y);
    }

    public static void mediumControl(Point location) {
        startPoint = finishPoint;
        finishPoint = location;
        DrawingArea.takeSnapshot();
    }
}
