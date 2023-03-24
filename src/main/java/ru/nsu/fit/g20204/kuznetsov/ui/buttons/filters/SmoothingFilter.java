package ru.nsu.fit.g20204.kuznetsov.ui.buttons.filters;

import ru.nsu.fit.g20204.kuznetsov.instruments.FilterType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;

public class SmoothingFilter extends ToolButton {
    public SmoothingFilter() {
        super("filters/smoothing.png", FilterType.SMOOTHING);
    }
}
