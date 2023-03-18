package ru.nsu.fit.g20204.kuznetsov.ui.buttons.stamps;



import ru.nsu.fit.g20204.kuznetsov.instruments.StampType;
import ru.nsu.fit.g20204.kuznetsov.ui.content.ToolBar;

import javax.swing.*;

public class StampsButtonGroup extends ButtonGroup {
    static private PolygonButton polygon;
    static private StarButton star;

    public void set(ToolBar toolBar) {
        initButtons();
        addInGroupAll();
        setOnPanelAll(toolBar);
    }

    void initButtons() {
        polygon = new PolygonButton();
        star = new StarButton();
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
            case Star -> star.doClick();
            case Polygon -> polygon.doClick();
        }
    }
}
