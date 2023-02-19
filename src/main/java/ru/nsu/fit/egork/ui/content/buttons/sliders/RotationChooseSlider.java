package ru.nsu.fit.egork.ui.content.buttons.sliders;

import ru.nsu.fit.egork.Hand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RotationChooseSlider  extends JSlider {
    public RotationChooseSlider() {
        super(HORIZONTAL, -180, 180, Hand.getAngle());
        setToolTipText("Angle setting: " + getValue());

        for(int i = -180; i < 180; i += 45) {
            setMajorTickSpacing(45);
            setMinorTickSpacing(0);
        }

        setPaintTicks(false);
        setPaintLabels(true);
        setPaintTrack(true);

        setMaximumSize(new Dimension(200, 30));

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
}
