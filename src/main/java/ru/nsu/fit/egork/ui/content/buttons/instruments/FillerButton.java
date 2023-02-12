package ru.nsu.fit.egork.ui.content.buttons.instruments;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.instruments.InstrumentType;
import ru.nsu.fit.egork.ui.content.buttons.tools.ToolButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FillerButton extends ToolButton {
    public FillerButton(int width, int height) {
        super(width,
                height,
                "instruments/fill.png",
                "Fill",
                InstrumentType.FILLER);
    }
}
