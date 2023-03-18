package ru.nsu.fit.g20204.kuznetsov.ui.content;

import ru.nsu.fit.g20204.kuznetsov.ui.settings.SettingsFrame;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {
    private static Content contentInstance = null;

    private Content() {
        super(new BorderLayout());

        var splitPaneV = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, SettingsFrame.getInstance(), ScrollDrawingArea.getInstance());
        splitPaneV.setResizeWeight(1);

        add(splitPaneV, BorderLayout.CENTER);
        add(new ToolBar(), BorderLayout.NORTH);
    }

    public static Content getInstance() {
        if (contentInstance == null) {
            contentInstance = new Content();
        }

        return contentInstance;
    }
}
