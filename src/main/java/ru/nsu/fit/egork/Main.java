package ru.nsu.fit.egork;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    Main() {
        super("Paint");
        defaultSet();

        pack();
        setVisible(true);
    }

    void defaultSet() {
        setPreferredSize(new Dimension(640, 480));
        setMinimumSize(new Dimension(640, 480));
        setResizable(false);
        setLocation(400, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}