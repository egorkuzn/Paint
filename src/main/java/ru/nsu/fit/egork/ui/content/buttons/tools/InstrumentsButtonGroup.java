package ru.nsu.fit.egork.ui.content.buttons.tools;


import ru.nsu.fit.egork.ui.content.Content;
import ru.nsu.fit.egork.ui.content.ToolBar;
import ru.nsu.fit.egork.ui.content.buttons.instruments.ColorChooseButton;
import ru.nsu.fit.egork.ui.content.buttons.instruments.EraserButton;
import ru.nsu.fit.egork.ui.content.buttons.instruments.FillerButton;
import ru.nsu.fit.egork.ui.content.buttons.instruments.LineButton;

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
        lineButton = new LineButton(width, height);
        eraserButton = new EraserButton(width, height);
        fillerButton = new FillerButton(width, height);
        colorChooseButton = new ColorChooseButton(width, height);
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
