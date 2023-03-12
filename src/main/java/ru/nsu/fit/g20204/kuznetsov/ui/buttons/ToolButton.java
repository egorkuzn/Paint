package ru.nsu.fit.g20204.kuznetsov.ui.buttons;


import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ToolButton extends JButton {
    protected Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private ToolButton toolButton = this;
    private static final HashMap<ToolButton, Boolean> pressedButtonsControl = new HashMap<>();

    /**
     * Contractor for instruments that need mouse control on drawing area like pen and line
     *
     * @param width
     * @param height
     * @param imagePath path to the image from <code>resources</code> dir
     * @param tip for showing some text on mouse cover
     * @param instrument
     */
    public ToolButton(int width,
                      int height,
                      String imagePath,
                      String tip,
                      InstrumentType instrument) {
        setFocusPainted(false);
        init(width, height, imagePath, tip);
        pressedButtonsControl.put(this, false);

        addActionListener(action -> {
            logger.info("Clicked");
            for (Map.Entry<ToolButton, Boolean> elem : pressedButtonsControl.entrySet()) {
                if (elem.getValue() && elem.getKey() != toolButton) {
                    elem.getKey().turnOff();
                    elem.setValue(false);
                }
            }


            boolean isPressed = !pressedButtonsControl.get(toolButton);
            setSelected(isPressed);

            if (isPressed) {
                logger.info(tip.toUpperCase() + " chosen");
                Hand.take(instrument);

                if (instrument == InstrumentType.STAMP) {
                    Hand.setStampType(StampType.valueOf(tip));
                }
            } else {
                logger.info("PENCIL chosen");
                Hand.take(InstrumentType.PENCIL);
            }

            pressedButtonsControl.put(toolButton, isPressed);
        });
    }

    public void turnOff() {
        setSelected(false);
    }

    /**
     * Similar as upper but for filters, <code>ColorChooseButton</code>, <code>FileManagerButton</code>,
     * <code>SettingsButton</code>.
     *
     * @param width
     * @param height
     * @param imagePath
     * @param tip
     */
    public ToolButton(int width,
                      int height,
                      String imagePath,
                      String tip) {
        setFocusPainted(false);
        init(width, height, imagePath, tip);
    }

    private void init(int width,
                      int height,
                      String imagePath,
                      String tip) {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(imagePath);

        try {
            var img = ImageIO.read(stream);
            var icon = new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
            setIcon(icon);
        } catch (IllegalArgumentException | IOException e) {
            logger.warning("Bad resource path");
        }

        setToolTipText(tip.toUpperCase());
        setMaximumSize(new Dimension(width, height));
    }
}
