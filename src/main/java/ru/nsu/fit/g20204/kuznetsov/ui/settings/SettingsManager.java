package ru.nsu.fit.g20204.kuznetsov.ui.settings;

import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.mode.StampSettings;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.mode.WidthSettings;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.mode.filters.BlackAndWhiteSettings;

public class SettingsManager {
    public static void set(InstrumentType instrument) {
        switch (instrument) {
            case FILTER -> setFilterController();
            case STAMP -> StampSettings.set();
            case PENCIL, ERASER, LINE -> WidthSettings.set();
            default -> {
                return;
            }
        }
    }

    private static void setFilterController() {
        switch (Hand.getFilterType()) {
            case BLACK_AND_WHITE -> BlackAndWhiteSettings.set();

            default -> {
                return;
            }
        }
    }
}
