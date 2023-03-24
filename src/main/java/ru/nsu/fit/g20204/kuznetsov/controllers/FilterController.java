package ru.nsu.fit.g20204.kuznetsov.controllers;

import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.History;
import ru.nsu.fit.g20204.kuznetsov.controllers.filters.BlackAndWhiteController;
import ru.nsu.fit.g20204.kuznetsov.controllers.filters.RotationController;
import ru.nsu.fit.g20204.kuznetsov.controllers.filters.SmoothingFilterController;

import java.awt.*;
import java.util.logging.Logger;

public class FilterController implements Controller {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static boolean click = false;

    public static void paint(Graphics g) {
        if (click) {
            logger.info(Hand.getFilterType().name());

            switch (Hand.getFilterType()) {
                case BLACK_AND_WHITE -> BlackAndWhiteController.performImage();
                case ROTATION -> RotationController.performImage();
                case SMOOTHING -> SmoothingFilterController.performImage(g);
            }

            click = false;
        }
    }

    public static void beginControl(Point point) {
        if (isInImage(point)) {
            click = true;
        }
    }

    private static boolean isInImage(Point point) {
        return point.y < History.getMaxHeight() && point.x < History.getMaxWidth();
    }

    public static void finishControl(Point point) {

    }

    public static void mediumControl(Point point) {
    }
}
