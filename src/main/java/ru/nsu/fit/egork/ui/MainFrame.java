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
    static MainFrame mainFrame = null;

    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        mainFrame = new MainFrame();
    }

    private MainFrame() {
        super("Paint");
        setNativeView();
        defaultSet();
        addAll();
        pack();
        setVisible(true);
    }

    public static MainFrame getInstance() {
        if(mainFrame == null) {
            mainFrame = new MainFrame();
        }

        return mainFrame;
    }

    void addAll() {
        var menuBar = Menu.getBar();
        var content = Content.getInstance();

        setJMenuBar(menuBar);
        setContentPane(content);
    }

    void defaultSet() {
        setMinimumSize(new Dimension(640, 480));
        setResizable(true);
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

    void setNativeView() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            logger.warning("This OS hasn't 'UIManager.setLookAndFeel' or you need give this app more access");
        }
    }
}