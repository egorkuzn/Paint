package ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders;

import ru.nsu.fit.g20204.kuznetsov.Hand;

public class RotationSlider extends BaseSlider {
    private static RotationSlider rotationSlider = null;

    private RotationSlider() {
        super(-180, 180, "Angle setting: ");
    }

    public static RotationSlider getInstance() {
        if (rotationSlider == null) {
            rotationSlider = new RotationSlider();
        }

        return rotationSlider;
    }

    @Override
    protected void onRelease() {
        Hand.setAngle(getValue());
    }
}
