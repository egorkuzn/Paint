package ru.nsu.fit.g20204.kuznetsov.ui.buttons.instruments;


import ru.nsu.fit.g20204.kuznetsov.ui.content.ToolBar;

import javax.swing.*;

public class InstrumentsButtonGroup {
    public void set(ToolBar toolBar) {
        toolBar.add(HandButton.getInstance());
        HandButton.getInstance().doClick();
        toolBar.add(PencilButton.getInstance());
        toolBar.add(LineButton.getInstance());
        toolBar.add(EraserButton.getInstance());
        toolBar.add(FillerButton.getInstance());
        toolBar.add(ColorChooseButton.getInstance());
    }
}
