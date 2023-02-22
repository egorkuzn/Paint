package ru.nsu.fit.egork;

import ru.nsu.fit.egork.instruments.InstrumentType;
import ru.nsu.fit.egork.ui.content.buttons.sliders.RotationChooseSlider;
import ru.nsu.fit.egork.ui.content.buttons.sliders.WidthChooseSlider;
import ru.nsu.fit.egork.ui.content.buttons.textfields.RotationTextField;
import ru.nsu.fit.egork.ui.content.buttons.textfields.WidthTextField;

import java.awt.*;

public class Hand {
    private static Hand hand = null;
    private static InstrumentType instrument = InstrumentType.PENCIL;
    private static Color color = new Color(0, 0, 0);
    private static int width = 1;
    private static int angle = 0;

    private Hand() {}

    public static Hand getInstance() {
        if (hand == null) {
            hand = new Hand();
        }

        return hand;
    }

    public static void take(InstrumentType newInstrument) {
        getInstance();
        // TODO: Необходимо добавить action или listener связанный
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

    public static int getAngle() {
        return angle;
    }

    public static void setAngle(int value) {
        angle = value;
        RotationChooseSlider.set(value);
        RotationTextField.set(value);
    }
}
