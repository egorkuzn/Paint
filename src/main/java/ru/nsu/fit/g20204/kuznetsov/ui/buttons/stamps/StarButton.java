package ru.nsu.fit.g20204.kuznetsov.ui.buttons.stamps;

import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;

public class StarButton extends ToolButton {
    public StarButton() {
        super("stamps/star.png",
                StampType.STAR);
    }
}
