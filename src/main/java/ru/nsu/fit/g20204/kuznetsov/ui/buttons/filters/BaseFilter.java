package ru.nsu.fit.g20204.kuznetsov.ui.buttons.filters;

import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;

public class BaseFilter extends ToolButton {
    public BaseFilter(String imagePath, String tip) {
        super(imagePath, tip, InstrumentType.FILTER);
    }
}
