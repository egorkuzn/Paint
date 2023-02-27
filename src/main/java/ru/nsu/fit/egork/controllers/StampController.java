package ru.nsu.fit.egork.controllers;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.ui.content.DrawingArea;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class StampController implements Controller {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static Point point = null;
    private static boolean isStartedPaint = false;

    public static void control() {}

    public static void beginControl(Point location) {
        if (isStartedPaint)
            DrawingArea.takeSnapshot();

        isStartedPaint = !isStartedPaint;
        point = location;
        logger.info("stamp begin control");
    }

    public static void finishControl(Point location) {

    }

    public static void paint(Graphics g) {
        if (isStartedPaint) {
            Graphics2D g2 = (Graphics2D) g;
            var xArr = new ArrayList<Integer>();
            var yArr = new ArrayList<Integer>();

            getPolygonTops(xArr, yArr);

            g2.setColor(Hand.getColor());
            g2.setStroke(new BasicStroke(Hand.getWidth()));
            g2.drawPolygon(xArr.stream().mapToInt(Integer::valueOf).toArray(),
                    yArr.stream().mapToInt(Integer::valueOf).toArray(),
                    xArr.size());
        }
    }

    private static void getPolygonTops(ArrayList<Integer> xArr, ArrayList<Integer> yArr) {
        for (
                double alpha = Hand.getAngle();
                alpha < 2.0 * Math.PI + Hand.getAngle();
                alpha += 2.0 * Math.PI / Hand.getTopsCount()
        ) {
            xArr.add((int) (Hand.getRadius() * Math.cos(alpha)) + point.x);
            yArr.add((int) (Hand.getRadius() * Math.sin(alpha)) + point.y);
        }
    }

    public static void mediumControl() {
    }
}
