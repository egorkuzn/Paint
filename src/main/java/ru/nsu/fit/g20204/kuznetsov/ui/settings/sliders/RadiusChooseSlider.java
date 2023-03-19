package ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders;


import ru.nsu.fit.g20204.kuznetsov.Hand;

public class RadiusChooseSlider extends BaseSlider {
    private static RadiusChooseSlider radiusChooseSlider = null;

    public RadiusChooseSlider() {
        super(1, 1000, "Radius setting: ");
    }

    public static RadiusChooseSlider getInstance() {
        if (radiusChooseSlider == null) {
            radiusChooseSlider = new RadiusChooseSlider();
        }

        return radiusChooseSlider;
    }

    @Override
    protected void onRelease() {
        Hand.setRadius(getValue());
    }
}
