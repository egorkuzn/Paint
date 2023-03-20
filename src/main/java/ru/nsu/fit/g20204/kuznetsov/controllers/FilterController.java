package ru.nsu.fit.g20204.kuznetsov.controllers;

import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.controllers.filters.BlackAndWhiteController;
import ru.nsu.fit.g20204.kuznetsov.controllers.filters.RotationController;

import java.awt.*;

public class FilterController implements Controller {
    public static void paint(Graphics g) {
        switch (Hand.getFilterType()) {
            case BLACK_AND_WHITE -> BlackAndWhiteController.performImage();
            case ROTATION -> RotationController.performImage();
        }
    }

    public static void beginControl(Point point) {
    }

    public static void finishControl(Point point) {
    }

    public static void mediumControl(Point point) {
    }
    // TODO: release base functions
}
