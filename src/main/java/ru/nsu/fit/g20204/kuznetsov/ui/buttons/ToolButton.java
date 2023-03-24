package ru.nsu.fit.g20204.kuznetsov.ui.buttons;


import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.instruments.FilterType;
import ru.nsu.fit.g20204.kuznetsov.instruments.InstrumentType;
import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.SettingsLabel;
import ru.nsu.fit.g20204.kuznetsov.util.SettingsManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public abstract class ToolButton extends JButton {

    private String name;
    private boolean settingsStatus = true;

    protected Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final ToolButton toolButton = this;
    private static final HashMap<ToolButton, Boolean> pressedButtonsControl = new HashMap<>();

    /**
     * Contractor for instruments that need mouse control on drawing area like pen and line
     *
     * @param imagePath  path to the image from <code>resources</code> dir
     * @param tip        for showing some text on mouse cover
     * @param instrument
     */
    public ToolButton(String imagePath,
                      String tip,
                      InstrumentType instrument) {
        init(imagePath, tip);
        pressedButtonsControl.put(this, false);
        addActionListener(action -> {
            actionListenerAdder(instrument);
        });
    }

    /**
     * Stamp tool button constructor
     */
    public ToolButton(String imagePath,
                      StampType stampType) {
        init(imagePath, stampType.name().toLowerCase() + " stamp");
        pressedButtonsControl.put(this, false);
        addActionListener(action -> {
            actionListenerAdder(InstrumentType.STAMP);
            Hand.setStampType(stampType);
        });
    }

    /**
     * Filter tool button constructor
     */
    public ToolButton(String imagePath,
                      FilterType filterType) {
        init(imagePath, filterType.name().toLowerCase() + " filter");
        pressedButtonsControl.put(this, false);
        addActionListener(action -> {
            actionListenerAdder(InstrumentType.FILTER);
            Hand.setFilterType(filterType);
        });
    }

    private void actionListenerAdder(InstrumentType instrument) {
        logger.info("Clicked");
        turnOffAll();
        chosenViewUpdate(instrument);

        if (instrument.isSettable()) {
            settingsLabelUpdate(instrument);
        } else {
            SettingsLabel.getInstance().setVisible(false);
        }

        pressedButtonsControl.put(toolButton, true);
    }

    private void settingsLabelUpdate(InstrumentType instrument) {
        SettingsManager.set(instrument);

        if (!pressedButtonsControl.get(toolButton)) {
            SettingsLabel.getInstance().setVisible(false);
        } else {
            SettingsLabel.getInstance().setVisible(settingsStatus);
            settingsStatus = !settingsStatus;
        }
    }

    private void turnOffAll() {
        for (Map.Entry<ToolButton, Boolean> elem : pressedButtonsControl.entrySet()) {
            if (elem.getValue() && elem.getKey() != toolButton) {
                elem.getKey().turnOff();
                elem.setValue(false);
            }
        }
    }

    private void chosenViewUpdate(InstrumentType instrument) {
        if (!pressedButtonsControl.get(toolButton)) {
            setSelected(true);
        }

        Hand.take(instrument);
    }

    public void turnOff() {
        setSelected(false);
    }

    /**
     * Similar as upper but for <code>ColorChooseButton</code>, <code>OpenButton</code>,
     * <code>SettingsButton</code>.
     *
     * @param imagePath
     * @param tip
     */
    public ToolButton(String imagePath,
                      String tip) {
        init(imagePath, tip);
    }

    private void init(String imagePath,
                      String tip) {
        name = tip;
        setFocusPainted(false);

        InputStream stream = getClass().getClassLoader().getResourceAsStream(imagePath);

        int width = 25;
        int height = 25;

        try {
            var img = ImageIO.read(stream);
            var icon = new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
            setIcon(icon);
        } catch (IllegalArgumentException | IOException e) {
            logger.warning("Bad resource path");
        }

        setToolTipText(tip);
        setMaximumSize(new Dimension(width, height));
    }

    public String getName() {
        return name;
    }
}
