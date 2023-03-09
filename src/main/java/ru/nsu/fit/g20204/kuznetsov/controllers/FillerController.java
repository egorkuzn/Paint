package ru.nsu.fit.g20204.kuznetsov.controllers;

import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.History;
import ru.nsu.fit.g20204.kuznetsov.ui.content.DrawingArea;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Stack;
import java.util.logging.Logger;

public class FillerController implements Controller {
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
            History.setMaxWidth(DrawingArea.getInstance().getWidth());
            History.setMaxHeight(DrawingArea.getInstance().getHeight());

            setImageGraphics();
            colorToBePainted = image.getRGB(finishPoint.x, finishPoint.y);

            // Алгоритм span-заливки
            spanFillAlgo();

            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), DrawingArea.getInstance());
            History.saveScreen(image);

            isToDraw = false;
            logger.info("Filled");
        }
    }

    private static void setImageGraphics() {
        var img = History.getLastScreen();
        image = new BufferedImage(History.getMaxWidth(), History.getMaxHeight(), img.getType());
        image.getGraphics().setColor(Color.WHITE);
        image.getGraphics().fillRect(0, 0, History.getMaxWidth(), History.getMaxHeight());
        image.getGraphics().drawImage(img, 0, 0, img.getWidth(), img.getHeight(), DrawingArea.getInstance());
    }

    private static void spanFillAlgo() {
        var stack = new Stack<Point>();
        var point = new Point(finishPoint);
        stack.push(point);

        while (!stack.isEmpty()) {
            point = stack.pop();
            var lx = point.x;

            while (isInside(lx - 1, point.y)) {
                image.setRGB(lx - 1, point.y, Hand.getColor().getRGB());
                lx -= 1;
            }

            while (isInside(point.x, point.y)) {
                image.setRGB(point.x, point.y, Hand.getColor().getRGB());
                ++point.x;
            }

            scan(lx, point.x - 1, point.y + 1, stack);
            scan(lx, point.x - 1, point.y - 1, stack);
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
        if (Hand.getColor().getRGB() == image.getRGB(x, y))
            return false;
        // Если цвет точки не совпадает с цветом закрашиваемой точки
        return colorToBePainted == image.getRGB(x, y);
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
