package ru.nsu.fit.egork.ui.content.buttons.instruments;

import ru.nsu.fit.egork.instruments.InstrumentType;
import ru.nsu.fit.egork.ui.content.Content;
import ru.nsu.fit.egork.ui.content.DrawingArea;
import ru.nsu.fit.egork.ui.content.buttons.tools.ToolButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooseButton extends ToolButton {
    static Palette colorChooser = null;

    public ColorChooseButton(int width, int height) {
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
                    // TODO: переделать, чтобы не затиралось
                    DrawingArea.getInstance().removeAll();
                    DrawingArea.getInstance().revalidate();
                    DrawingArea.getInstance().repaint();
                    Content.getInstance().add(colorChooser, BorderLayout.SOUTH);
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
}
