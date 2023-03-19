package ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields;

import ru.nsu.fit.g20204.kuznetsov.Hand;

public class PolygonTopsTextField extends BaseTextField {
    private static PolygonTopsTextField polygonTopsTextField = null;
    private static final int limit = 50;

    public PolygonTopsTextField() {
        super(limit, Hand.getTopsCount());
    }

    public static PolygonTopsTextField getInstance() {
        if (polygonTopsTextField == null) {
            polygonTopsTextField = new PolygonTopsTextField();
        }

        return polygonTopsTextField;
    }

    @Override
    protected void onRelease(int value) {
        Hand.setTopsCount(value);
    }
}
