package ru.nsu.fit.egork.ui.content.buttons.stamps;

import ru.nsu.fit.egork.ui.content.ToolBar;

import javax.swing.*;

public class StampsButtonGroup extends ButtonGroup {
    PolygonButton polygon;
    StarButton star;

    public void set(ToolBar toolBar, int width, int height) {
        initButtons(width, height);
        addInGroupAll();
        setOnPanelAll(toolBar);
    }

    void initButtons(int width, int height) {
        polygon = new PolygonButton(width, height);
        star = new StarButton(width, height);
    }

    void addInGroupAll() {
        add(polygon);
        add(star);
    }

    void setOnPanelAll(ToolBar toolBar) {
        toolBar.add(polygon);
        toolBar.add(star);
    }
}
