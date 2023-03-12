package ru.nsu.fit.g20204.kuznetsov.ui.buttons.colors;

import ru.nsu.fit.g20204.kuznetsov.ui.content.ToolBar;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.colors.ColorButton;

import javax.swing.*;
import java.util.ArrayList;

public class ColorButtonGroup extends ButtonGroup {
    private static final ArrayList<ColorButton> colorButtons = new ArrayList<>();

    public void set(ToolBar toolBar, int bWidth, int bHeight) {
        initButtons(bWidth, bHeight);
        setOnPaneAll(toolBar);
    }

    private void initButtons(int bWidth, int bHeight) {
        for (int i = 0; i < 7; i++) {
            ColorButton colorButton = new ColorButton(bWidth, bHeight);
            add(colorButton);
            colorButtons.add(colorButton);
        }
    }

    private void setOnPaneAll(ToolBar toolBar) {
        for (ColorButton colorButton : colorButtons) {
            toolBar.add(colorButton);
        }
    }
}
