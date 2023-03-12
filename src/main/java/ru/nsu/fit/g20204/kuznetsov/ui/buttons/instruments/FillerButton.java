package ru.nsu.fit.g20204.kuznetsov.ui.buttons.instruments;


import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;

public class FillerButton extends ToolButton {
    private static FillerButton fillerButton = null;

    private FillerButton(int width, int height) {
        super(width,
                height,
                "instruments/fill.png",
                "Fill",
                InstrumentType.FILLER);
    }

    public static FillerButton getInstance(int width, int height) {
        if (fillerButton == null) {
            fillerButton = new FillerButton(width, height);
        }

        return fillerButton;
    }
}
