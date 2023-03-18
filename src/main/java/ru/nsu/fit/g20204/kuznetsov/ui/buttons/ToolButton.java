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
    final private int width = 30;
    final private int height = 30;

    private final String name;

    protected Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private ToolButton toolButton = this;
    private static final HashMap<ToolButton, Boolean> pressedButtonsControl = new HashMap<>();

    /**
     * Contractor for instruments that need mouse control on drawing area like pen and line
     *
     * @param imagePath path to the image from <code>resources</code> dir
     * @param tip for showing some text on mouse cover
     * @param instrument
     */
    public ToolButton(String imagePath,
                      String tip,
                      InstrumentType instrument) {
        name = tip;
        setFocusPainted(false);
        init(imagePath, tip);
        pressedButtonsControl.put(this, false);

        addActionListener(action -> {
            logger.info("Clicked");
            for (Map.Entry<ToolButton, Boolean> elem : pressedButtonsControl.entrySet()) {
                if (elem.getValue() && elem.getKey() != toolButton) {
                    elem.getKey().turnOff();
                    elem.setValue(false);
                }
            }

            if (!pressedButtonsControl.get(toolButton)) {
                setSelected(true);
            }

            logger.info(tip.toUpperCase() + " chosen");
            Hand.take(instrument);

            if (instrument == InstrumentType.STAMP) {
                Hand.setStampType(StampType.valueOf(tip));
            }

            pressedButtonsControl.put(toolButton, true);
        });
    }

    public void turnOff() {
        setSelected(false);
    }

    /**
     * Similar as upper but for <code>ColorChooseButton</code>, <code>FileManagerButton</code>,
     * <code>SettingsButton</code>.
     *
     * @param imagePath
     * @param tip
     */
    public ToolButton(String imagePath,
                      String tip) {
        name = tip;
        setFocusPainted(false);
        init(imagePath, tip);
    }

    private void init(String imagePath,
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

    public String getName() {
        return name;
    }
}
