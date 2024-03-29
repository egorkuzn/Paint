package ru.nsu.fit.g20204.kuznetsov.ui.buttons.instruments;


import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;

import java.util.logging.Logger;

public class EraserButton extends ToolButton {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static EraserButton eraserButton = null;

    public EraserButton() {
        super("instruments/eraser.png",
                "Eraser",
                InstrumentType.ERASER);
    }

    public static EraserButton getInstance() {
        if (eraserButton == null) {
            eraserButton = new EraserButton();
        }

        return eraserButton;
    }
}
