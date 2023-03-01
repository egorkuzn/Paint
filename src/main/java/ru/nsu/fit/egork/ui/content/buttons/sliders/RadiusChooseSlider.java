package ru.nsu.fit.egork.ui.content.buttons.sliders;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.ui.content.buttons.textfields.RotationTextField;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RadiusChooseSlider extends JSlider {
    private static RadiusChooseSlider radiusChooseSlider = null;

    public RadiusChooseSlider() {
        super(HORIZONTAL, 1, 1000, Hand.getRadius());
        setToolTipText("Radius setting: " + getValue());

//        for(int i = 0; i < 1000; i += 100) {
        setMajorTickSpacing(999);
        setMinorTickSpacing(1);

        setPaintTicks(false);
        setPaintLabels(true);
        setPaintTrack(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Hand.setRadius(getValue());
                setToolTipText("Radius setting: " + getValue());
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                Hand.setRadius(getValue());
                setToolTipText("Radius setting: " + getValue());
            }
        });
    }

    public static RadiusChooseSlider getInstance() {
        if (radiusChooseSlider == null) {
            radiusChooseSlider = new RadiusChooseSlider();
        }

        return radiusChooseSlider;
    }

    public static void set(int value) {
        getInstance().setValue(value);
    }
}
