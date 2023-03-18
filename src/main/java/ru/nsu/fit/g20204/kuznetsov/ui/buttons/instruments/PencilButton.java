package ru.nsu.fit.g20204.kuznetsov.ui.buttons.instruments;

import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;

public class PencilButton extends ToolButton {
    private static PencilButton pencilButton = null;

    public PencilButton() {
        super("instruments/pencil.png",
                "Pencil",
                InstrumentType.PENCIL);
    }

    public static PencilButton getInstance() {
        if (pencilButton == null) {
            pencilButton = new PencilButton();
        }

        return pencilButton;
    }
}
