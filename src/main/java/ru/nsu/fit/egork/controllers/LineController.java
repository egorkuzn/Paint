package ru.nsu.fit.egork.controllers;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.History;
import ru.nsu.fit.egork.ui.MainFrame;
import ru.nsu.fit.egork.ui.content.DrawingArea;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.logging.Logger;

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
            if (Hand.getWidth() != 1) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Hand.getColor());
                g2.setStroke(new BasicStroke(Hand.getWidth()));
                g2.drawLine(startPoint.x,
                        startPoint.y,
                        finishPoint.x,
                        finishPoint.y);
            } else {
                brazenhemAlgo(g);
            }
        }
    }

    private static void brazenhemAlgo(Graphics g) {
        int dx = Math.abs(finishPoint.x - startPoint.x);
        int dy = Math.abs(finishPoint.y - startPoint.y);
        int err = -dx;

        DrawingArea.getInstance().removeAll();
        DrawingArea.getInstance().validate();
        DrawingArea.getInstance().repaint();

        var img = History.getLastScreen();
        var newImg = new BufferedImage(History.getMaxWidth(), History.getMaxHeight(), img.getType());
        newImg.setData(img.getData());

        if (dy <= dx) {
            if ((finishPoint.x - startPoint.x) * (finishPoint.y - startPoint.y) >= 0) {
                int x = Math.min(startPoint.x, finishPoint.x);
                int y = Math.min(startPoint.y, finishPoint.y);

                for (int i = 0; i < dx; ++i) {
                    x++;
                    err += 2 * dy;

                    if (err > 0) {
                        err -= 2 * dx;
                        y++;
                    }

                    if (x < newImg.getWidth() && y < newImg.getHeight()) {
                        newImg.setRGB(x, y, Hand.getColor().getRGB());
                    } else {
                        logger.info("Out of img board");
                    }
                }
            } else {
                int x = Math.min(startPoint.x, finishPoint.x);
                int y = Math.max(startPoint.y, finishPoint.y);

                for (int i = 0; i < dx; ++i) {
                    x++;
                    err += 2 * dy;

                    if (err > 0) {
                        err -= 2 * dx;
                        y--;
                    }

                    if (x < newImg.getWidth() && y < newImg.getHeight()) {
                        newImg.setRGB(x, y, Hand.getColor().getRGB());
                    } else {
                        logger.info("Out of img board");
                    }
                }
            }
        } else {
            if ((finishPoint.x - startPoint.x) * (finishPoint.y - startPoint.y) >= 0) {
                int x = Math.min(startPoint.x, finishPoint.x);
                int y = Math.min(startPoint.y, finishPoint.y);

                for (int i = 0; i < dy; ++i) {
                    y++;
                    err += 2 * dx;

                    if (err > 0) {
                        err -= 2 * dy;
                        x++;
                    }

                    if (x < newImg.getWidth() && y < newImg.getHeight()) {
                        newImg.setRGB(x, y, Hand.getColor().getRGB());
                        //newImg.getRGB(x,y)
                    } else {
                        logger.info("Out of img board");
                    }
                }
            } else {
                int x = Math.max(startPoint.x, finishPoint.x);
                int y = Math.min(startPoint.y, finishPoint.y);

                for (int i = 0; i < dy; ++i) {
                    y++;
                    err += 2 * dx;

                    if (err > 0) {
                        err -= 2 * dy;
                        x--;
                    }

                    if (x < newImg.getWidth() && y < newImg.getHeight()) {
                        newImg.setRGB(x, y, Hand.getColor().getRGB());
                    } else {
                        logger.info("Out of img board");
                    }
                }
            }
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(newImg, 0, 0, newImg.getWidth(), newImg.getHeight(), DrawingArea.getInstance());
    }
}
