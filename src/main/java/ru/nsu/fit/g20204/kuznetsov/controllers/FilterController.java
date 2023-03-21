package ru.nsu.fit.g20204.kuznetsov.controllers;

import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.controllers.filters.BlackAndWhiteController;
import ru.nsu.fit.g20204.kuznetsov.controllers.filters.RotationController;

import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.History;
import ru.nsu.fit.g20204.kuznetsov.ui.content.DrawingArea;

import java.awt.*;
import java.util.logging.Logger;

public class FilterController implements Controller {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void paint(Graphics g) {
        switch (Hand.getFilterType()) {
            case BLACK_AND_WHITE -> BlackAndWhiteController.performImage();
            case ROTATION -> RotationController.performImage();
            case SMOOTHING -> {
                History.getLastScreen();
                DrawingArea.takeSnapshot();
            }
        }
    }

    public static void beginControl(Point point) {
        logger.info("filter put");
    }

    public static void finishControl(Point point) {

    }

    public static void mediumControl(Point point) {
    }
    // TODO: release base functions
}
