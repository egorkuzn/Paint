package ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields;


import ru.nsu.fit.g20204.kuznetsov.Hand;

public class RadiusTextField extends BaseTextField {
    private static RadiusTextField radiusTextField = null;
    private static final int limit = 1000;

    public RadiusTextField() {
        super(limit, Hand.getRadius());
    }

    public static RadiusTextField getInstance() {
        if (radiusTextField == null) {
            radiusTextField = new RadiusTextField();
        }

        return radiusTextField;
    }

    @Override
    protected void onRelease(int value) {
        Hand.setRadius(value);
    }
}
