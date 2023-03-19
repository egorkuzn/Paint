package ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders;

import ru.nsu.fit.g20204.kuznetsov.Hand;

public class WidthSlider extends BaseSlider {
    private static WidthSlider widthSlider = null;

    private WidthSlider() {
        super(1, 100, "Width setting: ");
    }

    public static WidthSlider getInstance() {
        if (widthSlider == null) {
            widthSlider = new WidthSlider();
        }

        return widthSlider;
    }

    @Override
    protected void onRelease() {
        Hand.setWidth(getValue());
    }
}
