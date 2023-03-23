package ru.nsu.fit.g20204.kuznetsov.ui.buttons.filters;

import ru.nsu.fit.g20204.kuznetsov.ui.content.ToolBar;

import javax.swing.*;

public class FiltersButtonGroup extends ButtonGroup {

    /**
     *
     * @param toolBar
     */
    public void set(ToolBar toolBar) {
        // TODO("Release filters buttons add");
        //        add(new Filter1(...));
        toolBar.add(new SmoothingFilter());
    }
}
