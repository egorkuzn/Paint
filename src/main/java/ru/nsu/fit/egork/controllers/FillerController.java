package ru.nsu.fit.egork.controllers;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.History;
import ru.nsu.fit.egork.ui.content.DrawingArea;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Stack;
import java.util.logging.Logger;

public class FillerController implements Controller{
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static Point finishPoint = new Point();
    private static BufferedImage image = null;
    private static int colorToBePainted;
    private static boolean isToDraw = false;

    public static void control() {

    }

    public static void beginControl(Point location) {
        finishPoint = location;
        isToDraw = true;
        logger.info("Released");
    }

    public static void finishControl() {

    }

    public static void paint(Graphics g) {
        if (isToDraw) {
            DrawingArea.getInstance().removeAll();
            DrawingArea.getInstance().validate();
            DrawingArea.getInstance().repaint();

            var img = History.getLastScreen();
            image = new BufferedImage(History.getMaxWidth(), History.getMaxHeight(), img.getType());
            image.setData(img.getData());
            colorToBePainted = image.getRGB(finishPoint.x, finishPoint.y);

            Graphics2D g2 = (Graphics2D) g;

            // Начало алгоритма span-заливки
            var stack = new Stack<Point>();
            var point = new Point(finishPoint);
            stack.push(point);

            while (!stack.isEmpty()) {
                point = stack.pop();
                var lx = point.x;

                while (isInside(lx - 1, point.y)) {
                    image.setRGB(lx - 1, point.y, Hand.getColor().getRGB());
                    image.flush();
                    lx -= 1;
                }

                while (isInside(point.x, point.y)) {
                    image.setRGB(point.x, point.y, Hand.getColor().getRGB());
                    image.flush();
                    ++point.x;
                }

                scan(lx, point.x - 1, point.y + 1, stack);
                scan(lx, point.x - 1, point.y - 1, stack);
                logger.info(Integer.toString(stack.size()));
            }

            g2.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), DrawingArea.getInstance());
            History.saveScreen(image);
            isToDraw = false;
            logger.info("Filled");
        }
    }

    private static boolean isInside(int x, int y) {
        // Если справа за границей
        if (x >= image.getWidth())
            return false;
        // Если за левой границей
        if (x < 0)
            return false;
        // Если за верхней границей
        if (y < 0)
            return false;
        // Если за нижней границей
        if (y >= image.getHeight())
            return false;
        // Если цвет точки не совпадает с цветом закрашиваемой точки
        if (colorToBePainted != image.getRGB(x, y))
            return false;

        return true;
    }

    private static void scan(int lx, int rx, int y, Stack<Point> stack) {
        var isSpanAdded = false;

        for (int x = lx; x <= rx; ++x) {
            if (!isInside(x, y)) {
                isSpanAdded = false;
            } else if (!isSpanAdded) {
                stack.push(new Point(x, y));
                isSpanAdded = true;
            }
        }
    }

    public static void mediumControl() {

    }
}
