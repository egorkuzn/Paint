package ru.nsu.fit.g20204.kuznetsov.ui.content.buttons.tools;

import ru.nsu.fit.g20204.kuznetsov.ui.content.buttons.sliders.*;
import ru.nsu.fit.g20204.kuznetsov.ui.content.buttons.textfields.*;

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
        setLayout(null);
    }

    public static SettingsFrame getInstance() {
        if (settingsFrame == null) {
            settingsFrame = new SettingsFrame();
        }

        settingsFrame.setVisible(true);

        return settingsFrame;
    }

    void defaultSet() {
        setMinimumSize(new Dimension(380, 260));
        setResizable(false);
        setLocation(100, 100);
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
        var b1 = WidthChooseSlider.getInstance();
        var b2 = RotationChooseSlider.getInstance();
        var b3 = RadiusChooseSlider.getInstance();
        var b4 = PolygonTopsSlider.getInstance();
        var b5 = PolygonTopsTextField.getInstance();
        var b6 = WidthTextField.getInstance();
        var b7 = RotationTextField.getInstance();
        var b8 = RadiusTextField.getInstance();
        var widthText = new JLabel("Width");
        var rotationAngleText = new JLabel("<html>Rotation<br>angle</html>");
        var radiusText = new JLabel("Radius");
        var polygonTopsCountText = new JLabel("<html>Polygon tops<br>count</html>");

        Insets insets = getInsets();

        add(b4);
        add(b3);
        add(b2);
        add(b1);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(widthText);
        add(rotationAngleText);
        add(radiusText);
        add(polygonTopsCountText);

        b1.setVisible(true);
        b2.setVisible(true);

        Dimension size = b1.getPreferredSize();
        b1.setBounds(insets.left, 5 + insets.top, size.width, size.height);
        b2.setBounds(insets.left, 60 + insets.top, size.width, size.height);
        b3.setBounds(insets.left, 115 + insets.top, size.width, size.height);
        b4.setBounds(insets.left, 170 + insets.top, size.width, size.height);

        size = b6.getPreferredSize();
        b6.setBounds(225 + insets.left, 5 + insets.top, 50, size.height + 6);
        b7.setBounds(225 + insets.left, 60 + insets.top, 50, size.height + 6);
        b8.setBounds(225 + insets.left, 115 + insets.top, 50, size.height + 6);
        b5.setBounds(225 + insets.left, 170 + insets.top, 50, size.height + 6);

        widthText.setBounds(280 + insets.left, 5 + insets.top, 200, size.height + 6);
        rotationAngleText.setBounds(280 + insets.left, 60 + insets.top, 200, size.height + 14);
        radiusText.setBounds(280 + insets.left, 115 + insets.top, 200, size.height + 6);
        polygonTopsCountText.setBounds(280 + insets.left, 170 + insets.top, 200, size.height + 6);

        setSize(300 + insets.left + insets.right, 125 + insets.top + insets.bottom);
    }


}
