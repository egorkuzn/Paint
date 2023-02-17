package ru.nsu.fit.egork.ui.content.buttons.sliders;

import ru.nsu.fit.egork.Hand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WidthChooseSlider extends JSlider {
    public WidthChooseSlider() {
        super(HORIZONTAL, 1, 10, 1);
        setToolTipText("Width setting: " + getValue());
        setMajorTickSpacing(9);
        setMinorTickSpacing(1);

        setPaintTicks(false);
        setPaintLabels(true);
        setPaintTrack(true);

        setMaximumSize(new Dimension(200, 30));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Hand.setWidth(getValue());
                setToolTipText("Width setting: " + getValue());
            }
        });
    }
}
