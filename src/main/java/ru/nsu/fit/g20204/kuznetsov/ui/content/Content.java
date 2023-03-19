package ru.nsu.fit.g20204.kuznetsov.ui.content;

import ru.nsu.fit.g20204.kuznetsov.ui.settings.SettingsLabel;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {
    private static Content contentInstance = null;

    private Content() {
        super(new BorderLayout());
        add(SettingsLabel.getInstance(), BorderLayout.EAST);
        add(ScrollDrawingArea.getInstance());

        add(new ToolBar(), BorderLayout.NORTH);
    }

    public static Content getInstance() {
        if (contentInstance == null) {
            contentInstance = new Content();
        }

        return contentInstance;
    }
}
