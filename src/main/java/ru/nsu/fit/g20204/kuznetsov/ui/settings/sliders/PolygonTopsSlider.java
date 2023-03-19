package ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders;

import ru.nsu.fit.g20204.kuznetsov.Hand;

public class PolygonTopsSlider extends BaseSlider {
    private static PolygonTopsSlider polygonTopsSlider = null;

    public PolygonTopsSlider() {
        super(1, 50, "Tops count setting: ");
    }

    public static PolygonTopsSlider getInstance() {
        if (polygonTopsSlider == null) {
            polygonTopsSlider = new PolygonTopsSlider();
        }

        return polygonTopsSlider;
    }

    @Override
    protected void onRelease() {
        Hand.setTopsCount(getValue());
    }
}
