package ru.nsu.fit.g20204.kuznetsov.util;

import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.SettingsLabel;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.mode.StampSettings;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.mode.WidthSettings;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.mode.filters.BlackAndWhiteSettings;

public class SettingsManager {
    private static final SettingsLabel S = SettingsLabel.getInstance();

    public static void set(InstrumentType instrument) {
        switch (instrument) {
            case FILTER -> setFilterController();
            case STAMP -> StampSettings.set();
            case PENCIL, ERASER, LINE -> WidthSettings.set();
            default -> {
                S.removeAll();
                S.revalidate();
            }
        }
    }

    private static void setFilterController() {
        switch (Hand.getFilterType()) {
            case BLACK_AND_WHITE -> BlackAndWhiteSettings.set();

            default -> {
                S.removeAll();
                S.revalidate();
            }
        }
    }
}
