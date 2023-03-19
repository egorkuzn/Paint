package ru.nsu.fit.g20204.kuznetsov.ui.buttons.stamps;

import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;

public class PolygonButton extends StampButton {
    public PolygonButton() {
        super("stamps/polygon.png",
                StampType.Polygon.name(),
                InstrumentType.STAMP);
    }
}
