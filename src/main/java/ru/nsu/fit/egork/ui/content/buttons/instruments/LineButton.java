package ru.nsu.fit.egork.ui.content.buttons.instruments;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.instruments.InstrumentType;
import ru.nsu.fit.egork.ui.content.buttons.tools.ToolButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LineButton extends ToolButton {
    public LineButton(int width, int height) {
        super(width,
                height,
                "instruments/line.png",
                "Straight line",
                InstrumentType.LINE);
    }
}
