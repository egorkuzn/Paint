package ru.nsu.fit.egork.ui.content.buttons.instruments;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.instruments.InstrumentType;
import ru.nsu.fit.egork.ui.content.buttons.tools.ToolButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

public class EraserButton extends ToolButton {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public EraserButton(int width, int height) {
        super(width,
                height,
                "instruments/eraser.png",
                "Eraser",
                InstrumentType.ERASER);
    }
}
