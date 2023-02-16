package ru.nsu.fit.egork.ui.menu;

import ru.nsu.fit.egork.History;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class Redo extends JMenuItem {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static int number = 0;
    private static Redo redo = null;

    private Redo() {
        super();
        setIcon();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (number == 1) {
                    History.toNextScreen();
                }
            }
        });
    }

    public static Redo getInstance() {
        if (redo == null) {
            redo = new Redo();
        }

        return redo;
    }

    private void setIcon() {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("arrows/redo" + number + ".png");

        try {
            var img = ImageIO.read(stream);
            var icon = new ImageIcon(img.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            setIcon(icon);
        } catch (IllegalArgumentException | IOException e) {
            logger.warning("Bad resource path");
        }

        setMaximumSize(new Dimension(30, 30));
        setMinimumSize(new Dimension(30, 30));
    }

    public void activateRedo() {
        number = 1;
        setIcon();
    }

    public void deactivateRedo() {
        number = 0;
        setIcon();
    }
}
