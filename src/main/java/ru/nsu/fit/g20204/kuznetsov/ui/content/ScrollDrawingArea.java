package ru.nsu.fit.g20204.kuznetsov.ui.content;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScrollDrawingArea extends JScrollPane {
    private static ScrollDrawingArea scrollDrawingArea = null;
    private static boolean scrollStatus = false;
    private static Point origin;

    private ScrollDrawingArea() {
        super(DrawingArea.getInstance());
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                origin = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int deltaX = origin.x - e.getX();
                int deltaY = origin.y - e.getY();
                var view = getVisibleRect();
                view.x += deltaX;
                view.y += deltaY;
                scrollRectToVisible(view);
            }
        });
    }

    public static ScrollDrawingArea getInstance() {
        if (scrollDrawingArea == null) {
            scrollDrawingArea = new ScrollDrawingArea();
        }

        return scrollDrawingArea;
    }

    public void enableDraggingScroll() {
        scrollStatus = true;
    }

    public void disableDraggingScroll() {
        scrollStatus = false;
    }
}
