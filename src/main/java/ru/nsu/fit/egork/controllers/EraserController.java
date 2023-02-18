package ru.nsu.fit.egork.controllers;

import ru.nsu.fit.egork.Hand;

import java.awt.*;
import java.awt.event.MouseAdapter;

public class EraserController extends PencilController{
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
