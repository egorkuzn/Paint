package ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders;

import ru.nsu.fit.g20204.kuznetsov.Hand;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WidthChooseSlider extends JSlider {
    private static WidthChooseSlider widthChooseSlider = null;

    private WidthChooseSlider() {
        super(HORIZONTAL, 1, 100, Hand.getWidth());
        setToolTipText("Width setting: " + getValue());

        setMajorTickSpacing(99);
        setMinorTickSpacing(1);

        setPaintTicks(false);
        setPaintLabels(true);
        setPaintTrack(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Hand.setWidth(getValue());
                setToolTipText("Width setting: " + getValue());
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                Hand.setWidth(getValue());
                setToolTipText("Width setting: " + getValue());
            }
        });
    }

    public static WidthChooseSlider getInstance() {
        if (widthChooseSlider == null) {
            widthChooseSlider = new WidthChooseSlider();
        }

        return widthChooseSlider;
    }

    public static void set(int value) {
        getInstance().setValue(value);
    }
}
