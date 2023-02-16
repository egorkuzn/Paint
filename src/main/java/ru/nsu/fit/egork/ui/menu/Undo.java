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

public class Undo extends JMenuItem {
    private static Undo undo = null;
    private static int number = 0;
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private Undo() {
        super();
        setIcon();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (number == 1) {
                    logger.info("Undo released");
                    History.turnToLastScreen();
                    Redo.getInstance().activateRedo();
                }
            }
        });
    }

    public static Undo getInstance() {
        if (undo == null) {
            undo = new Undo();
        }

        return undo;
    }

    private void setIcon() {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("arrows/undo" + number +".png");

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

    public void activateUndo() {
        number = 1;
        setIcon();
    }

    public void deactivateUndo() {
        number = 0;
        setIcon();
    }
}
