package ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields;

import ru.nsu.fit.g20204.kuznetsov.Hand;

public class RotationTextField extends BaseTextField {
    private static RotationTextField rotationTextField = null;
    private static final int limit = 360;

    private RotationTextField() {
        super(limit, Hand.getAngleDegrees());
    }

    public static RotationTextField getInstance() {
        if (rotationTextField == null) {
            rotationTextField = new RotationTextField();
        }

        return rotationTextField;
    }

    @Override
    protected void onRelease(int value) {
        Hand.setAngle(value);
    }
}
