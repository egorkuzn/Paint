package ru.nsu.fit.egork.ui.content.buttons.tools;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class ToolButton extends JButton {
    protected Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public ToolButton(int width, int height, String imagePath, String tip) {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(imagePath);

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
}
