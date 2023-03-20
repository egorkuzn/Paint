package ru.nsu.fit.g20204.kuznetsov.ui.buttons.filters.aphine;

import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.instruments.FilterType;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.filters.BaseFilter;

public class Rotation extends BaseFilter {
    public Rotation() {
        super("filters/aphine/rotation.png", "Rotation");
        Hand.setFilterType(FilterType.ROTATION);
    }
}
