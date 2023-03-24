package ru.nsu.fit.g20204.kuznetsov.util;

import ru.nsu.fit.g20204.kuznetsov.History;
import ru.nsu.fit.g20204.kuznetsov.ui.content.DrawingArea;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FilterUtil {
    public static BufferedImage getNewImage() {
        var img = History.getLastScreen();
        var image = new BufferedImage(History.getMaxWidth(), History.getMaxHeight(), img.getType());
        image.getGraphics().setColor(Color.WHITE);
        image.getGraphics().fillRect(0, 0, History.getMaxWidth(), History.getMaxHeight());
        image.getGraphics().drawImage(img, 0, 0, img.getWidth(), img.getHeight(), DrawingArea.getInstance());

        return image;
    }
}
