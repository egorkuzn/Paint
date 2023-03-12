package ru.nsu.fit.g20204.kuznetsov.ui.buttons.instruments;


import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;

public class LineButton extends ToolButton {
    private static LineButton lineButton = null;

    private LineButton(int width, int height) {
        super(width,
                height,
                "instruments/line.png",
                "Straight line",
                InstrumentType.LINE);
    }

    public static LineButton getInstance(int width, int height) {
        if (lineButton == null) {
            lineButton = new LineButton(width, height);
        }

        return lineButton;
    }

    public static LineButton getInstance() {
        return lineButton;
    }
}
