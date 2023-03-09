package ru.nsu.fit.g20204.kuznetsov.ui.content.buttons.instruments;

import ru.nsu.fit.g20204.kuznetsov.ui.content.Content;
import ru.nsu.fit.g20204.kuznetsov.ui.content.buttons.tools.ToolButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooseButton extends ToolButton {
    static Palette colorChooser = null;
    private static ColorChooseButton colorChooseButton = null;

    private ColorChooseButton(int width, int height) {
        super(width,
                height,
                "instruments/palette.png",
                "Color palette");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (colorChooser == null) {
                    colorChooser = new Palette();
                    logger.info("Pushed color");
                    colorChooser.setLocation(0, 0);

                    Content.getInstance().add(colorChooser, BorderLayout.SOUTH);
                    Content.getInstance().revalidate();
                } else {
                    logger.info("Cleared");
                    colorChooser.removeAll();
                    colorChooser.revalidate();
                    colorChooser.repaint();
                    colorChooser = null;
                }
            }
        });
    }

    public static ColorChooseButton getInstance(int width, int height) {
        if (colorChooseButton == null) {
            colorChooseButton = new ColorChooseButton(width, height);
        }

        return colorChooseButton;
    }
}
