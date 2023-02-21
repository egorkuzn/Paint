package ru.nsu.fit.egork.ui.content.buttons.tools;

import ru.nsu.fit.egork.ui.content.buttons.sliders.RotationChooseSlider;
import ru.nsu.fit.egork.ui.content.buttons.sliders.WidthChooseSlider;
import ru.nsu.fit.egork.ui.content.buttons.textfields.RotationTextField;
import ru.nsu.fit.egork.ui.content.buttons.textfields.WidthTextField;

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
        controllersSet();
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

    private void controllersSet() {
        WidthChooseSlider b1 = new WidthChooseSlider();
        RotationChooseSlider b2 = new RotationChooseSlider();
        WidthTextField b3 = new WidthTextField();
        RotationTextField b4 = new RotationTextField();

        add(b1);
        add(b2);
        add(b3);
        add(b4);

        Insets insets = getInsets();
        Dimension size = b1.getPreferredSize();
        b1.setBounds(insets.left, 5 + insets.top, size.width, size.height);
        b2.setBounds(insets.left, 60 + insets.top, size.width, size.height);

        size = b3.getPreferredSize();
        b3.setBounds(225 + insets.left, 5 + insets.top, (int) (size.width * 1.5), size.height + 3);
        b4.setBounds(225 + insets.left, 60 + insets.top, (int) (size.width * 1.5), size.height + 3);

        setSize(300 + insets.left + insets.right, 125 + insets.top + insets.bottom);
    }
}
