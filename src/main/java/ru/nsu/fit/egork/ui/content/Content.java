package ru.nsu.fit.egork.ui.content;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {
    public Content() {
        super(new BorderLayout());
        add(new DrawingArea());
        add(new ToolBar(), BorderLayout.NORTH);
    }
}
