package ru.nsu.fit.egork;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class History {
    private static History history = null;
    private static final ArrayList<BufferedImage> screens = new ArrayList<>();
    private static String currentPath = null;

    private History() {

    }

    public static History getInstance() {
        if (history == null) {
            history = new History();
        }

        return history;
    }

    public static ArrayList<BufferedImage> getScreens() {
        getInstance();
        return screens;
    }

    public static BufferedImage getLastScreen() {
        getInstance();
        return screens.get(screens.size() - 1);
    }

    public static void saveScreen(BufferedImage img) {
        getInstance();
        screens.add(img);
    }

    public static String getFileName() {
        return "new_file.png";
    }

    public static void setPath(String path) {
        currentPath = path;
    }

    public static String getPath() {
        return currentPath;
    }

    public static String getFormat() {
        if (currentPath != null) {
            return currentPath.substring(currentPath.lastIndexOf(".") + 1);
        } else {
            return null;
        }
    }
}
