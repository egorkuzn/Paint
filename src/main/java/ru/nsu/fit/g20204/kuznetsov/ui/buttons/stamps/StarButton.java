package ru.nsu.fit.g20204.kuznetsov.ui.buttons.stamps;

import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;

public class StarButton extends StampButton {
    public StarButton() {
        super("stamps/star.png",
                StampType.Star.name(),
                InstrumentType.STAMP);
    }
}
