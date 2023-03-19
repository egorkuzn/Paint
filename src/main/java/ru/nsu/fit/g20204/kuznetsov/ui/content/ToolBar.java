package ru.nsu.fit.g20204.kuznetsov.ui.content;

import ru.nsu.fit.g20204.kuznetsov.ui.buttons.filters.FiltersButtonGroup;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.stamps.StampsButtonGroup;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.colors.ColorButtonGroup;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.filemanager.FileManagerButton;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.instruments.InstrumentsButtonGroup;

import javax.swing.*;

/**
 * Class for visualisation instruments on toolbar.
 */
public class ToolBar extends JToolBar {
    InstrumentsButtonGroup instrumentsButtonGroup = new InstrumentsButtonGroup();
    StampsButtonGroup stampsButtonGroup = new StampsButtonGroup();
    ColorButtonGroup colorButtonGroup = new ColorButtonGroup();
    FiltersButtonGroup filtersButtonGroup = new FiltersButtonGroup();


    /**
     * Add new buttons group here. And don't forget about separator.
     */
    public ToolBar() {
        super("Instruments");
        add(new FileManagerButton());
        addSeparator();
        instrumentsButtonGroup.set(this);
        addSeparator();
        stampsButtonGroup.set(this);
        addSeparator();
        colorButtonGroup.set(this);
        addSeparator();
        filtersButtonGroup.set(this);
    }
}
