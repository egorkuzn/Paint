package ru.nsu.fit.egork;

import ru.nsu.fit.egork.instruments.InstrumentType;

import java.awt.*;

public class Hand {
    private static Hand hand = null;
    private static InstrumentType instrument = InstrumentType.PENCIL;
    private static Color color = new Color(0, 0, 0);

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
}
