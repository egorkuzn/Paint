package ru.nsu.fit.g20204.kuznetsov;

import ru.nsu.fit.g20204.kuznetsov.instruments.FilterType;
import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders.PolygonSlider;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders.RadiusSlider;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders.RotationSlider;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders.WidthSlider;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields.PolygonTopsTextField;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields.RadiusTextField;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields.RotationTextField;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields.WidthTextField;

import java.awt.*;

public class Hand {
    private static InstrumentType instrument = InstrumentType.HAND;
    private static Color color = Color.BLACK;
    private static FilterType filterType = FilterType.BLACK_AND_WHITE;
    private static int width = 10;
    private static int angle = 0;
    private static int topsCount = 5;
    private static int radiusValue = 200;
    private static int x = 0;
    private static int y = 0;
    private static StampType stampType = StampType.Polygon;

    public static void take(InstrumentType newInstrument) {
        instrument = newInstrument;
    }

    public static InstrumentType getInstrument() {
        return instrument;
    }

    public static void changeColor(Color newColor) {
        color = newColor;
    }

    public static Color getColor() {
        return color;
    }

    public static void setWidth(int newValue) {
        width = newValue;
        WidthTextField.getInstance().set(newValue);
        WidthSlider.getInstance().set(newValue);
    }

    public static int getWidth() {
        return width;
    }

    public static double getAngle() {
        return angle / 180.0 * Math.PI;
    }

    public static int getAngleDegrees() {
        return angle;
    }

    public static void setAngle(int value) {
        angle = value;
        RotationSlider.getInstance().set(value);
        RotationTextField.getInstance().set(value);
    }

    public static int getTopsCount() {
        return topsCount;
    }

    public static void setTopsCount(int value) {
        topsCount = value;
        PolygonSlider.getInstance().set(value);
        PolygonTopsTextField.getInstance().set(value);
    }

    public static int getRadius() {
        return radiusValue;
    }

    public static void setRadius(int value) {
        radiusValue = value;
        RadiusSlider.getInstance().set(value);
        RadiusTextField.getInstance().set(value);
    }

    public static void setStampType(StampType type) {
        stampType = type;
    }

    public static StampType getStampType() {
        return stampType;
    }

    public static FilterType getFilterType() {
        return filterType;
    }

    public static int yDimension() {
        return y;
    }

    public static int xDimension() {
        return x;
    }

    public static void setDimension(Point point) {
        y = point.y;
        x = point.x;
    }
}
