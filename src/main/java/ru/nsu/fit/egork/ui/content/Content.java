package ru.nsu.fit.egork.ui.content;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {
    private static Content contentInstance = null;

    private Content() {
        super(new BorderLayout());
        add(DrawingArea.getInstance());
        add(new ToolBar(), BorderLayout.NORTH);
    }

    public static Content getInstance() {
        if (contentInstance == null) {
            contentInstance = new Content();
        }

        return contentInstance;
    }
}
