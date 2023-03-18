package ru.nsu.fit.g20204.kuznetsov.ui.buttons.stamps;

import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;

public class PolygonButton extends ToolButton {
    public PolygonButton() {
        super("stamps/polygon.png",
                "POLYGON",
                InstrumentType.STAMP);
    }
}
