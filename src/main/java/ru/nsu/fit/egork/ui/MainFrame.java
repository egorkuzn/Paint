package ru.nsu.fit.egork.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class MainFrame extends JFrame {
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
        var drawingArea = new DrawingArea();
        var toolBar = new ToolBar();
        var menuBar = Menu.getBar();

        setJMenuBar(menuBar);
        add(toolBar, BorderLayout.SOUTH);
        add(drawingArea);
    }

    void defaultSet() {
        setPreferredSize(new Dimension(640, 480));
        setMinimumSize(new Dimension(640, 480));
        setResizable(false);
        setLocation(400, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIcon();
    }

    void setIcon() {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("icon.png");

        try {
            setIconImage(new ImageIcon(ImageIO.read(stream)).getImage());
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Bad resource path");
        }
    }
}