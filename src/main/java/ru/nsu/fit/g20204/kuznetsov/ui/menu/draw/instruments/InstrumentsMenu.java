package ru.nsu.fit.g20204.kuznetsov.ui.menu.draw.instruments;


import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;
import ru.nsu.fit.g20204.kuznetsov.ui.buttons.instruments.*;

import javax.swing.*;

public class InstrumentsMenu extends JMenu {
    private static final ToolButton[] array = {
            HandButton.getInstance(),
            PencilButton.getInstance(),
            LineButton.getInstance(),
            EraserButton.getInstance(),
            FillerButton.getInstance(),
            ColorChooseButton.getInstance()
    };

    public InstrumentsMenu() {
        super("Instruments");

        for (ToolButton elem: array)
            add(new InstrumentMenuItem(elem));
    }
}
