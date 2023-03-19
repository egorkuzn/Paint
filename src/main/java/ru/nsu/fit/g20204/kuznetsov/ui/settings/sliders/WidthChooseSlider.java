package ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders;

import ru.nsu.fit.g20204.kuznetsov.Hand;

public class WidthChooseSlider extends BaseSlider {
    private static WidthChooseSlider widthChooseSlider = null;

    private WidthChooseSlider() {
        super(1, 100, "Width setting: ");
    }

    public static WidthChooseSlider getInstance() {
        if (widthChooseSlider == null) {
            widthChooseSlider = new WidthChooseSlider();
        }

        return widthChooseSlider;
    }

    @Override
    protected void onRelease() {
        Hand.setWidth(getValue());
    }
}
