package ru.nsu.fit.g20204.kuznetsov.ui.content;

import ru.nsu.fit.egork.ui.content.buttons.tools.ColorButtonGroup;
import ru.nsu.fit.egork.ui.content.buttons.stamps.StampsButtonGroup;
import ru.nsu.fit.egork.ui.content.buttons.tools.FileManagerButton;
import ru.nsu.fit.egork.ui.content.buttons.tools.InstrumentsButtonGroup;
import ru.nsu.fit.egork.ui.content.buttons.tools.SettingsButton;

import javax.swing.*;

public class ToolBar extends JToolBar {
    InstrumentsButtonGroup instrumentsButtonGroup = new InstrumentsButtonGroup();
    StampsButtonGroup stampsButtonGroup = new StampsButtonGroup();
    ColorButtonGroup colorButtonGroup = new ColorButtonGroup();

    int bWidth = 30;
    int bHeight = 30;

    public ToolBar() {
        super("Instruments");
        add(new FileManagerButton(bWidth, bHeight));
        addSeparator();
        add(new SettingsButton(bWidth, bHeight));
        addSeparator();
        instrumentsButtonGroup.set(this, bWidth, bHeight);
        addSeparator();
        stampsButtonGroup.set(this, bWidth, bHeight);
        addSeparator();
        colorButtonGroup.set(this, bWidth, bHeight);
    }
}
