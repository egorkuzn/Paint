package ru.nsu.fit.g20204.kuznetsov.controllers;

import ru.nsu.fit.g20204.kuznetsov.ui.content.DrawingArea;
import ru.nsu.fit.g20204.kuznetsov.ui.content.ScrollDrawingArea;

import java.awt.*;

public class HandController implements Controller {
    private static Point beginPoint;

    public static void paint(Graphics g) {
    }

    public static void beginControl(Point point) {
        beginPoint = point;
    }

    public static void finishControl() {
        DrawingArea.takeSnapshot();
    }

    public static void mediumControl(Point point) {
        ScrollDrawingArea.getInstance().onDragged(point, beginPoint);
    }
}
