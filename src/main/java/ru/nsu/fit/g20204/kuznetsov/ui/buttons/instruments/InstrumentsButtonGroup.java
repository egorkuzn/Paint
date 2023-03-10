package ru.nsu.fit.g20204.kuznetsov.ui.buttons.instruments;


import ru.nsu.fit.g20204.kuznetsov.ui.content.ToolBar;

import javax.swing.*;

public class InstrumentsButtonGroup extends ButtonGroup {
    LineButton lineButton;
    EraserButton eraserButton;
    FillerButton fillerButton;
    ColorChooseButton colorChooseButton;

    public void set(ToolBar toolBar, int width, int height) {
        initButtons(width, height);
        addInGroupAll();
        setOnPanelAll(toolBar);
    }

    void initButtons(int width, int height) {
        lineButton = LineButton.getInstance(width, height);
        eraserButton = EraserButton.getInstance(width, height);
        fillerButton = FillerButton.getInstance(width, height);
        colorChooseButton = ColorChooseButton.getInstance(width, height);
    }

    void addInGroupAll() {
        add(lineButton);
        add(eraserButton);
        add(fillerButton);
        add(colorChooseButton);
    }

    void setOnPanelAll(ToolBar toolBar) {
        toolBar.add(lineButton);
        toolBar.add(eraserButton);
        toolBar.add(fillerButton);
        toolBar.add(colorChooseButton);
    }
}
