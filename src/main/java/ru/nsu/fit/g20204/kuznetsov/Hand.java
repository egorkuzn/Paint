package ru.nsu.fit.g20204.kuznetsov;

import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders.*;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields.*;

import java.awt.*;

public class Hand {
    private static Hand hand = null;
    private static InstrumentType instrument = InstrumentType.PENCIL;
    private static Color color = Color.BLACK;
    private static int width = 10;
    private static int angle = 0;
    private static int topsCount = 5;
    private static int radiusValue = 200;
    private static StampType stampType = StampType.POLYGON;

    private Hand() {}

    public static Hand getInstance() {
        if (hand == null) {
            hand = new Hand();
        }

        return hand;
    }

    public static void take(InstrumentType newInstrument) {
        getInstance();
        instrument = newInstrument;
    }

    public static InstrumentType getInstrument() {
        getInstance();
        return instrument;
    }

    public static void changeColor(Color newColor) {
        getInstance();
        color = newColor;
    }

    public static Color getColor(){
        getInstance();
        return color;
    }

    public static void setWidth(int newValue) {
        width = newValue;
        WidthTextField.set(newValue);
        WidthChooseSlider.set(newValue);
    }

    public static int getWidth() {
        return width;
    }

    public static double getAngle() {
        return angle / 180.0 * Math.PI;
    }

    public static int getAngleDegreese() {
        return angle;
    }

    public static void setAngle(int value) {
        angle = value;
        RotationChooseSlider.set(value);
        RotationTextField.set(value);
    }

    public static int getTopsCount() {
        return topsCount;
    }

    public static void setTopsCount(int value) {
        topsCount = value;
        PolygonTopsSlider.set(value);
        PolygonTopsTextField.set(value);
    }

    public static int getRadius() {
        return radiusValue;
    }

    public static void setRadius(int value) {
        radiusValue = value;
        RadiusChooseSlider.set(value);
        RadiusTextField.set(value);
    }

    public static void setStampType(StampType type) {
        stampType = type;
    }

    public static StampType getStampType() {
        return stampType;
    }
}
