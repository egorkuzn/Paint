package ru.nsu.fit.g20204.kuznetsov.ui.buttons.filters;

import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.instruments.FilterType;

public class SmoothingFilter extends BaseFilter{
    public SmoothingFilter() {
        super("filters/smoothing.png", "SmoothingFilter");
        Hand.setFilterType(FilterType.SMOOTHING);
    }
}
