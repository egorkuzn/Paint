package ru.nsu.fit.g20204.kuznetsov.ui.buttons.filters;

import ru.nsu.fit.g20204.kuznetsov.ui.content.ToolBar;

import javax.swing.*;

public class FiltersButtonGroup extends ButtonGroup {
    public void set(ToolBar toolBar) {
        toolBar.add(new SmoothingFilter());
    }
}
