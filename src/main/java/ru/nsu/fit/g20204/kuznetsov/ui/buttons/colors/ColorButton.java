package ru.nsu.fit.g20204.kuznetsov.ui.buttons.colors;

import ru.nsu.fit.g20204.kuznetsov.Hand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorButton extends JButton {
    static private final Color[] colorArray = {Color.RED,
            Color.YELLOW,
            Color.GREEN,
            Color.CYAN,
            Color.BLUE,
            Color.MAGENTA,
            Color.WHITE};
    static byte pointer = 0;

    public ColorButton(int width, int height) {
        super();
        setBackground(colorArray[pointer++]);
        setContentAreaFilled(true);
        setSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width,height));
        setMaximumSize(new Dimension(width, height));
        setEnabled(false);
        setBorder(BorderFactory.createLoweredBevelBorder());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Hand.changeColor(getBackground());
            }
        });
    }
}
