package ru.nsu.fit.egork.ui.content.buttons.stamps;

import ru.nsu.fit.egork.instruments.InstrumentType;
import ru.nsu.fit.egork.ui.content.buttons.tools.ToolButton;

public class StarButton extends ToolButton {
    public StarButton(int width, int height) {
        super(width,
                height,
                "stamps/star.png",
                "Star",
                InstrumentType.STAMP);
    }
}
