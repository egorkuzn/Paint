package ru.nsu.fit.g20204.kuznetsov.ui.buttons.stamps;

import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;

public class StarButton extends ToolButton {
    public StarButton(int width, int height) {
        super(width,
                height,
                "stamps/star.png",
                "STAR",
                InstrumentType.STAMP);
    }
}
