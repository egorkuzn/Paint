package ru.nsu.fit.egork.ui.content;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {
    private static Content contentInstance = null;

    private Content() {
        super(new BorderLayout());
        add(new DrawingArea());
        add(new ToolBar(), BorderLayout.NORTH);
    }

    public static Content getInstance() {
        if (contentInstance == null) {
            contentInstance = new Content();
        }

        return contentInstance;
    }
}
