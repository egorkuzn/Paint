package ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders;

import ru.nsu.fit.g20204.kuznetsov.Hand;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class BaseSlider extends JSlider {

    public BaseSlider(int min, int max, String toolTip) {
        super(HORIZONTAL, min, max, Hand.getTopsCount());
        setToolTipText(toolTip + getValue());


        setMajorTickSpacing(max - min);
        setMinorTickSpacing(min);

        setPaintTicks(false);
        setPaintLabels(true);
        setPaintTrack(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                onRelease();
                setToolTipText(toolTip + getValue());
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                onRelease();
                setToolTipText(toolTip + getValue());
            }
        });
    }

    public void set(int value) {
        setValue(value);
    }

    protected abstract void onRelease();
}
