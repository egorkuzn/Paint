package ru.nsu.fit.egork.ui.content.buttons.stamps;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.instruments.InstrumentType;
import ru.nsu.fit.egork.instruments.StampType;
import ru.nsu.fit.egork.ui.content.buttons.tools.ToolButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PolygonButton extends ToolButton {
    public PolygonButton(int width, int height) {
        super(width,
                height,
                "stamps/polygon.png",
                "POLYGON",
                InstrumentType.STAMP);
    }
}
