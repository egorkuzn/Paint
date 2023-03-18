package ru.nsu.fit.g20204.kuznetsov.ui.buttons.instruments;

import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;

public class HandButton extends ToolButton {
    private static HandButton handButton = null;

    public HandButton() {
        super("instruments/hand.png",
                "Hand",
                InstrumentType.HAND);
    }

    public static HandButton getInstance() {
        if (handButton == null) {
            handButton = new HandButton();
        }

        return handButton;
    }
}
