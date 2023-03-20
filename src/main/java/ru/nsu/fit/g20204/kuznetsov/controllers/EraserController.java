package ru.nsu.fit.g20204.kuznetsov.controllers;

import ru.nsu.fit.g20204.kuznetsov.Hand;

import java.awt.*;

public class EraserController extends PencilController {
    public static void paint(Graphics g) {
        if (show) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(Hand.getWidth()));
            g2.drawLine(startPoint.x,
                    startPoint.y,
                    finishPoint.x,
                    finishPoint.y);
        }
    }
}
