package ru.nsu.fit.egork.ui.content.buttons.instruments;

import ru.nsu.fit.egork.ui.MainFrame;
import ru.nsu.fit.egork.ui.content.Content;
import ru.nsu.fit.egork.ui.content.buttons.tools.ToolButton;

import javax.swing.*;
import javax.swing.plaf.ColorChooserUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooseButton extends ToolButton {
    static JColorChooser tcc = null;
    public ColorChooseButton(int width, int height) {
        super(width, height, "instruments/palette.png", "Color palette");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tcc == null) {
                    tcc = new JColorChooser();
                    logger.info("Pushed color");
                    tcc.setLocation(0, 0);
                    MainFrame.getInstance().add(tcc, BorderLayout.SOUTH);
                } else {
                    logger.info("Cleared");
                    tcc.removeAll();
                    tcc.revalidate();
                    tcc.repaint();
                    tcc = null;
                }
            }
        });
    }
}
