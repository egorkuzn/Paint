package ru.nsu.fit.egork.ui;

import ru.nsu.fit.egork.ui.content.Content;
import ru.nsu.fit.egork.ui.menu.Menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class MainFrame extends JFrame {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        new MainFrame();
    }

    MainFrame() {
        super("Paint");
        defaultSet();
        addAll();
        pack();
        setVisible(true);
    }

    void addAll() {
        var menuBar = Menu.getBar();
        var content = new Content();

        setJMenuBar(menuBar);
        setContentPane(content);
    }

    void defaultSet() {
        setMinimumSize(new Dimension(640, 480));
        setResizable(true);
        setLocation(400, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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