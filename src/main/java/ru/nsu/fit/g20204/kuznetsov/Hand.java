package ru.nsu.fit.g20204.kuznetsov;

import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders.PolygonTopsSlider;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders.RadiusChooseSlider;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders.RotationChooseSlider;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders.WidthChooseSlider;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields.PolygonTopsTextField;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields.RadiusTextField;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields.RotationTextField;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields.WidthTextField;

import java.awt.*;

public class Hand {
    private static InstrumentType instrument = InstrumentType.HAND;
    private static Color color = Color.BLACK;
    private static int width = 10;
    private static int angle = 0;
    private static int topsCount = 5;
    private static int radiusValue = 200;
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
        WidthChooseSlider.getInstance().set(newValue);
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
        RotationChooseSlider.getInstance().set(value);
        RotationTextField.getInstance().set(value);
    }

    public static int getTopsCount() {
        return topsCount;
    }

    public static void setTopsCount(int value) {
        topsCount = value;
        PolygonTopsSlider.getInstance().set(value);
        PolygonTopsTextField.getInstance().set(value);
    }

    public static int getRadius() {
        return radiusValue;
    }

    public static void setRadius(int value) {
        radiusValue = value;
        RadiusChooseSlider.getInstance().set(value);
        RadiusTextField.getInstance().set(value);
    }

    public static void setStampType(StampType type) {
        stampType = type;
    }

    public static StampType getStampType() {
        return stampType;
    }
}
