package ru.nsu.fit.g20204.kuznetsov.ui.content.buttons.stamps;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.instruments.InstrumentType;
import ru.nsu.fit.egork.instruments.StampType;
import ru.nsu.fit.egork.ui.content.buttons.tools.ToolButton;

public class StarButton extends ToolButton {
    public StarButton(int width, int height) {
        super(width,
                height,
                "stamps/star.png",
                "STAR",
                InstrumentType.STAMP);
    }
}
