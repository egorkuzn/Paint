package ru.nsu.fit.g20204.kuznetsov;

import ru.nsu.fit.g20204.kuznetsov.ui.content.DrawingArea;
import ru.nsu.fit.g20204.kuznetsov.ui.menu.undoredo.Redo;
import ru.nsu.fit.g20204.kuznetsov.ui.menu.undoredo.Undo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class History {
    private static History history = null;
    private static final ArrayList<BufferedImage> screens = new ArrayList<>();
    private static String currentPath = null;
    private static int currentScreenIndex = -1;
    private static int maxWidth = 1;
    private static int maxHeight = 1;

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

        if (currentScreenIndex <= 0 || currentScreenIndex >= screens.size()) {
            turnToLastScreen();
        }

        return screens.get(currentScreenIndex);
    }

    public static void saveScreen(BufferedImage img) {
        getInstance();

        if (screens.size() > currentScreenIndex + 1) {
            screens.subList(currentScreenIndex + 1, screens.size()).clear();
        }

        if (img.getHeight() < maxHeight || img.getWidth() < maxWidth) {
            BufferedImage newImg = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_RGB);
            newImg.getGraphics().setColor(Color.WHITE);
            newImg.getGraphics().fillRect(0, 0, maxWidth, maxHeight);
            newImg.setData(getLastScreen().getData());
            newImg.getGraphics().drawImage(img, 0, 0, img.getWidth(), img.getHeight(), Color.WHITE, DrawingArea.getInstance());
            img = newImg;
        }

        Redo.getInstance().deactivateRedo();
        Undo.getInstance().activateUndo();
        ++currentScreenIndex;
        screens.add(img);
    }

    public static void setPath(String path) {
        currentPath = path;
    }

    public static String getPath() {
        getInstance();
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
        }
    }

    public static void toNextScreen() {
        if (currentScreenIndex + 1 < screens.size()) {
            currentScreenIndex++;

            if (currentScreenIndex == screens.size() - 1) {
                Redo.getInstance().deactivateRedo();
            }
        } else {
            Redo.getInstance().deactivateRedo();
        }

        Undo.getInstance().activateUndo();
    }

    public static void setMaxWidth(int width) {
        if (width > maxWidth) {
            maxWidth = width;
            DrawingArea.getInstance().setPreferredSize(new Dimension(maxWidth, maxHeight));
        }
    }

    public static void setMaxHeight(int height) {
        if (height > maxHeight) {
            maxHeight = height;
            DrawingArea.getInstance().setPreferredSize(new Dimension(maxWidth, maxHeight));
        }
    }

    public static int getMaxHeight() {
        return maxHeight;
    }

    public static int getMaxWidth() {
        return maxWidth;
    }
}
