package ru.nsu.fit.g20204.kuznetsov.controllers;

import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;
import ru.nsu.fit.g20204.kuznetsov.ui.content.DrawingArea;

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

            if (Hand.getStampType() == StampType.Polygon) {
                getPolygonTops(xArr, yArr);
            } else {
                getStarTops(xArr, yArr);
            }

            g2.setColor(Hand.getColor());
            g2.setStroke(new BasicStroke(Hand.getWidth()));
            g2.drawPolygon(xArr.stream().mapToInt(Integer::valueOf).toArray(),
                    yArr.stream().mapToInt(Integer::valueOf).toArray(),
                    xArr.size());
        }
    }

    private static void getPolygonTops(ArrayList<Integer> xArr, ArrayList<Integer> yArr) {
        double alpha = Hand.getAngle();

        for (int i = 0; i < Hand.getTopsCount(); i++) {
            alpha += 2.0 * Math.PI / Hand.getTopsCount();
            xArr.add((int) (Hand.getRadius() * Math.cos(alpha)) + point.x);
            yArr.add((int) (Hand.getRadius() * Math.sin(alpha)) + point.y);
        }
    }

    private static void getStarTops(ArrayList<Integer> xArr, ArrayList<Integer> yArr) {
        if (Hand.getTopsCount() < 4 || Hand.getRadius() == 1) {
            getPolygonTops(xArr, yArr);
            return;
        }

        // Arrays for taking polygon tops
        var pxArr = new ArrayList<Integer>();
        var pyArr = new ArrayList<Integer>();

        getPolygonTops(pxArr, pyArr);

//         Arrays for taking crossings of lines
        var cxArr = new ArrayList<Integer>();
        var cyArr = new ArrayList<Integer>();

        getCrossings(cxArr, cyArr, pxArr, pyArr);

        for (int i = 0; i < Hand.getTopsCount(); i++) {
            xArr.add(cxArr.get((i + Hand.getTopsCount() - 2) % Hand.getTopsCount()));
            xArr.add(pxArr.get(i));

            yArr.add(cyArr.get((i + Hand.getTopsCount() - 2) % Hand.getTopsCount()));
            yArr.add(pyArr.get(i));
        }
    }

    private static void getCrossings(ArrayList<Integer> xArr,
                                     ArrayList<Integer> yArr,
                                     ArrayList<Integer> pxArr,
                                     ArrayList<Integer> pyArr) {
        for (int i = 0; i < Hand.getTopsCount(); i++) {
            var point = getCrossPoint(pxArr, pyArr, i, pxArr.size());

            xArr.add(point.x);
            yArr.add(point.y);
        }
    }

    private static Point getCrossPoint(ArrayList<Integer> pxArr,
                                       ArrayList<Integer> pyArr,
                                       int i,
                                       int size) {
        int x0 = pxArr.get(i);
        int y0 = pyArr.get(i);
        int x1 = pxArr.get((i + 1) % size);
        int y1 = pyArr.get((i + 1) % size);
        int x2 = pxArr.get((i + 2) % size);
        int y2 = pyArr.get((i + 2) % size);
        int x3 = pxArr.get((i + 3) % size);
        int y3 = pyArr.get((i + 3) % size);

        double x;
        double y;

        if (x0 == x2) {
            x = x0;

            double k_ = (double) (y3 - y1) / (double) (x3 - x1);
            double b_ = y1 - k_ * x1;

            y = k_ * x + b_;
        } else if (x1 == x3) {
            x = x1;

            double k = (double) (y2 - y0) / (double) (x2 - x0);
            double b = y0 - k * x0;

            y = k * x + b;
        } else {
            double k = (double) (y2 - y0) / (double) (x2 - x0);
            double k_ = (double) (y3 - y1) / (double) (x3 - x1);

            double b = y0 - k * x0;
            double b_ = y1 - k_ * x1;

            x = -(b - b_) / (k - k_);
            y = k * x + b;
        }

        return new Point((int) x, (int) y);
    }

    public static void mediumControl() {
    }
}
