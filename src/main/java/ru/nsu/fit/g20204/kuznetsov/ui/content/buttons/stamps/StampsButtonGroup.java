package ru.nsu.fit.g20204.kuznetsov.ui.content.buttons.stamps;



import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;
import ru.nsu.fit.g20204.kuznetsov.ui.content.ToolBar;

import javax.swing.*;

public class StampsButtonGroup extends ButtonGroup {
    static private PolygonButton polygon;
    static private StarButton star;

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

    public static void doClick(StampType type) {
        switch (type) {
            case STAR -> star.doClick();
            case POLYGON -> polygon.doClick();
        }
    }
}
