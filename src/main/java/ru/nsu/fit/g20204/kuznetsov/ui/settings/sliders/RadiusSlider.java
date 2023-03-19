package ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders;


import ru.nsu.fit.g20204.kuznetsov.Hand;

public class RadiusSlider extends BaseSlider {
    private static RadiusSlider radiusSlider = null;

    public RadiusSlider() {
        super(1, 1000, "Radius setting: ");
    }

    public static RadiusSlider getInstance() {
        if (radiusSlider == null) {
            radiusSlider = new RadiusSlider();
        }

        return radiusSlider;
    }

    @Override
    protected void onRelease() {
        Hand.setRadius(getValue());
    }
}
