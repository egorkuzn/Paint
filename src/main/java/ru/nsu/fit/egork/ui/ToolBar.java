package ru.nsu.fit.egork.ui;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.MAGENTA);
        g2.fillRect(0, 0, 640, 100);
    }
}
