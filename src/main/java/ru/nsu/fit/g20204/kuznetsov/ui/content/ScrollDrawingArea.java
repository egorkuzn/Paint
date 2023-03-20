package ru.nsu.fit.g20204.kuznetsov.ui.content;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class ScrollDrawingArea extends JScrollPane {
    private static ScrollDrawingArea scrollDrawingArea = null;

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private ScrollDrawingArea() {
        super(DrawingArea.getInstance());
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    public static ScrollDrawingArea getInstance() {
        if (scrollDrawingArea == null) {
            scrollDrawingArea = new ScrollDrawingArea();
        }

        return scrollDrawingArea;
    }

    public void onDragged(Point coordinate, Point beginPoint) {
        getVerticalScrollBar().setValue(getVerticalScrollBar().getValue() + (-coordinate.y + beginPoint.y) / 20);
        getHorizontalScrollBar().setValue(getHorizontalScrollBar().getValue() + (-coordinate.x + beginPoint.x) / 20);
        logger.info("move");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
