package ru.nsu.fit.g20204.kuznetsov.ui.content;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {
    private static Content contentInstance = null;

    private Content() {
        super(new BorderLayout());
        add(ScrollDrawingArea.getInstance(), BorderLayout.CENTER);
        add(new ToolBar(), BorderLayout.NORTH);

    }

    public static Content getInstance() {
        if (contentInstance == null) {
            contentInstance = new Content();
        }

        return contentInstance;
    }
}
