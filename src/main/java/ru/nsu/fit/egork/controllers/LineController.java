package ru.nsu.fit.egork.controllers;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.ui.MainFrame;
import ru.nsu.fit.egork.ui.content.DrawingArea;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class LineController implements Controller{
    private static final Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static Point startPoint = new Point();
    private static Point finishPoint = new Point();

    private static boolean isStartedPaint = false;

    public static void control() {

    }

    public static void beginControl(Point location) {
        isStartedPaint = true;
        startPoint = location;
        finishPoint = location;
        logger.info("beginControl");
        logger.info(location.x + "." + location.y);
    }

    public static void mediumControl(Point location) {
        finishPoint = location;



        logger.info("mediumControl");
    }

    public static void finishControl(Point location) {
        DrawingArea.takeSnapshot();
        isStartedPaint = false;
        finishPoint = location;
        logger.info("finishControl");
    }

    public static Point getStartPoint() {
        return startPoint;
    }

    public static Point getFinishPoint() {
        return finishPoint;
    }

    public static void paint(Graphics g) {
        if (isStartedPaint) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Hand.getColor());
            g2.setStroke(new BasicStroke(4));
            g2.drawLine(startPoint.x,
                    startPoint.y,
                    finishPoint.x,
                    finishPoint.y);
        }
    }
}
