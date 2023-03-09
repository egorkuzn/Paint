package ru.nsu.fit.g20204.kuznetsov.ui.content.buttons.instruments;


import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.ui.content.buttons.tools.ToolButton;

import java.util.logging.Logger;

public class EraserButton extends ToolButton {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static EraserButton eraserButton = null;

    public EraserButton(int width, int height) {
        super(width,
                height,
                "instruments/eraser.png",
                "Eraser",
                InstrumentType.ERASER);
    }

    public static EraserButton getInstance(int width, int height) {
        if (eraserButton == null) {
            eraserButton = new EraserButton(width, height);
        }

        return eraserButton;
    }
}
