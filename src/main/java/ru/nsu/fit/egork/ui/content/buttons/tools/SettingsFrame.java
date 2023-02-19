package ru.nsu.fit.egork.ui.content.buttons.tools;

import ru.nsu.fit.egork.ui.content.buttons.sliders.RotationChooseSlider;
import ru.nsu.fit.egork.ui.content.buttons.sliders.WidthChooseSlider;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class SettingsFrame extends JFrame {
    private static SettingsFrame settingsFrame = null;
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private SettingsFrame() {
        super("Settings");
        defaultSet();
        add(new WidthChooseSlider(), BorderLayout.NORTH);
        add(new RotationChooseSlider(), BorderLayout.SOUTH);
    }

    public static SettingsFrame getInstance() {
        if (settingsFrame == null) {
            settingsFrame = new SettingsFrame();
        }

        settingsFrame.setVisible(true);

        return settingsFrame;
    }

    void defaultSet() {
        setMinimumSize(new Dimension(300, 300));
        setLocation(100, 100);
        setResizable(false);
        setIcon();
    }

    void setIcon() {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("icon.png");

        try {
            if(stream != null) {
                setIconImage(new ImageIcon(ImageIO.read(stream)).getImage());
            } else {
                logger.warning("Bad resource path");
            }
        } catch (IllegalArgumentException | IOException e) {
            logger.warning("Cannot read image source");
        }
    }
}
