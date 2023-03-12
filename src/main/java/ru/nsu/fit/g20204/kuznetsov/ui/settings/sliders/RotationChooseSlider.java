package ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders;

import ru.nsu.fit.g20204.kuznetsov.Hand;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RotationChooseSlider extends JSlider {
    private static RotationChooseSlider rotationChooseSlider = null;

    private RotationChooseSlider() {
        super(HORIZONTAL, 0, 360, Hand.getAngleDegreese());
        setToolTipText("Angle setting: " + getValue());


        setMajorTickSpacing(90);
        setMinorTickSpacing(0);

        setPaintTicks(false);
        setPaintLabels(true);
        setPaintTrack(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Hand.setAngle(getValue());
                setToolTipText("Angle setting: " + getValue());
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                Hand.setAngle(getValue());
                setToolTipText("Angle setting: " + getValue());
            }
        });
    }

    public static RotationChooseSlider getInstance() {
        if (rotationChooseSlider == null) {
            rotationChooseSlider = new RotationChooseSlider();
        }

        return rotationChooseSlider;
    }

    public static void set(int value) {
        getInstance().setValue(value);
    }
}
