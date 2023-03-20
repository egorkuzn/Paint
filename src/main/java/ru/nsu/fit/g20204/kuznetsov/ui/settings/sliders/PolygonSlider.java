package ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders;

import ru.nsu.fit.g20204.kuznetsov.Hand;

public class PolygonSlider extends BaseSlider {
    private static PolygonSlider polygonTopsSlider = null;

    public PolygonSlider() {
        super(3, 50, "Tops count setting: ");
    }

    public static PolygonSlider getInstance() {
        if (polygonTopsSlider == null) {
            polygonTopsSlider = new PolygonSlider();
        }

        return polygonTopsSlider;
    }

    @Override
    protected void onRelease() {
        Hand.setTopsCount(getValue());
    }
}
