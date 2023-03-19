package ru.nsu.fit.g20204.kuznetsov.ui.content;

import ru.nsu.fit.g20204.kuznetsov.ui.settings.SettingsFrame;

import javax.swing.*;
import java.awt.*;

public class ScrollDrawingArea extends JScrollPane {
    private static ScrollDrawingArea scrollDrawingArea = null;

    private ScrollDrawingArea() {
        super(DrawingArea.getInstance());
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    public static ScrollDrawingArea getInstance() {
        if (scrollDrawingArea == null) {
            scrollDrawingArea = new ScrollDrawingArea();
        }

        return scrollDrawingArea;
    }
}
