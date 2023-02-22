package ru.nsu.fit.egork.controllers;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.History;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class FillerController implements Controller {
    private static Point point = null;

    public static void control() {

    }

    public static void beginControl() {
    }

    public static void finishControl(Point location) {
        point = location;
    }

    public static void paint(Graphics g) {
        if (point != null) {

        }

        point = null;
    }

    public static void mediumControl() {
    }

    private void spanFillAlgo() {
        Stack<> someStack;

        int x = point.x;
        int y = point.y;

        var img = History.getLastScreen();
        var newImg = new BufferedImage(History.getMaxWidth(), History.getMaxHeight(), img.getType());
        newImg.setData(img.getData());
        var prevColor = newImg.getRGB(x, y);

        // Продегаем до крайнего левого края
        while (prevColor == newImg.getRGB(x, y) && x > 0) {
            x--;
            newImg.setRGB(x, y, Hand.getColor().getRGB());
        }

        // Пробегаем до крайнего правого края
        while () {

        }
    }
}
