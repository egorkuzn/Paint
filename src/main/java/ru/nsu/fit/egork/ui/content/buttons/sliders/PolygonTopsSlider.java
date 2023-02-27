package ru.nsu.fit.egork.ui.content.buttons.sliders;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.ui.content.buttons.textfields.PolygonTopsTextField;
import ru.nsu.fit.egork.ui.content.buttons.textfields.RotationTextField;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PolygonTopsSlider extends JSlider {
    private static PolygonTopsSlider polygonTopsSlider = null;

    public PolygonTopsSlider() {
        super(HORIZONTAL, 1, 100, Hand.getTopsCount());
        setToolTipText("Tops count setting: " + getValue());


        setMajorTickSpacing(99);
        setMinorTickSpacing(1);

        setPaintTicks(false);
        setPaintLabels(true);
        setPaintTrack(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Hand.setTopsCount(getValue());
                setToolTipText("Tops count setting: " + getValue());
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                Hand.setTopsCount(getValue());
                setToolTipText("Tops count setting: " + getValue());
            }
        });
    }

    public static PolygonTopsSlider getInstance() {
        if (polygonTopsSlider == null) {
            polygonTopsSlider = new PolygonTopsSlider();
        }

        return polygonTopsSlider;
    }

    public static void set(int value) {
        getInstance().setValue(value);
    }
}
