package ru.nsu.fit.g20204.kuznetsov.ui.buttons.filters;

import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;

// TODO: add filter 1
public class Filter1 extends ToolButton {
    public Filter1(int width, int height, String imagePath, String tip) {
        super(width, height, imagePath, tip, InstrumentType.FILTER);
    }
}
