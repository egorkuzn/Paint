package ru.nsu.fit.egork;

import ru.nsu.fit.egork.ui.content.DrawingArea;
import ru.nsu.fit.egork.ui.menu.Redo;
import ru.nsu.fit.egork.ui.menu.Undo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class History {
    private static History history = null;
    private static final ArrayList<BufferedImage> screens = new ArrayList<>();
    private static String currentPath = null;
    private static int currentScreenIndex = -1;

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

        if (currentScreenIndex < 0 || currentScreenIndex >= screens.size()) {
            turnToLastScreen();
        }

        return screens.get(currentScreenIndex);
    }

    public static void saveScreen(BufferedImage img) {
        getInstance();

        if (screens.size() > currentScreenIndex + 1) {
            screens.subList(currentScreenIndex + 1, screens.size()).clear();
        }

        Redo.getInstance().deactivateRedo();
        Undo.getInstance().activateUndo();
        currentScreenIndex++;
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

    public static void turnToLastScreen() {
        if (currentScreenIndex > 0) {
            currentScreenIndex--;
        } else {
            currentScreenIndex = 0;

            Undo.getInstance().deactivateUndo();
            var buffer = new BufferedImage(DrawingArea.getInstance().getWidth(),
                    DrawingArea.getInstance().getHeight(),
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D g2 = (Graphics2D) buffer.getGraphics();
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());

            if(screens.isEmpty()) {
                screens.add(buffer);
            } else {
                screens.set(0, buffer);
            }
        }
    }

    public static void toNextScreen() {
        if(currentScreenIndex + 1 < screens.size()) {
            currentScreenIndex++;

            if (currentScreenIndex == screens.size() - 1) {
                Redo.getInstance().deactivateRedo();
            }
        } else {
            Redo.getInstance().deactivateRedo();
        }

        Undo.getInstance().activateUndo();
    }
}
