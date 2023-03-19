package ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders;

import ru.nsu.fit.g20204.kuznetsov.Hand;

public class RotationChooseSlider extends BaseSlider {
    private static RotationChooseSlider rotationChooseSlider = null;

    private RotationChooseSlider() {
        super(0, 360, "Angle setting: ");
    }

    public static RotationChooseSlider getInstance() {
        if (rotationChooseSlider == null) {
            rotationChooseSlider = new RotationChooseSlider();
        }

        return rotationChooseSlider;
    }

    @Override
    protected void onRelease() {
        Hand.setAngle(getValue());
    }
}
