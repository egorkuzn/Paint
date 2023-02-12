package ru.nsu.fit.egork.ui.content;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.controllers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingArea extends JPanel {
    private static DrawingArea drawingArea = null;

    private DrawingArea() {
        super(new BorderLayout());
        setMouseListener();
    }

    public static DrawingArea getInstance() {
        if (drawingArea == null) {
            drawingArea = new DrawingArea();
        }

        return drawingArea;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(4));
        g2.drawLine(0, 0, getWidth()-1, getHeight()-1);
    }

    private void setMouseListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                switch (Hand.getInstrument()) {
                    case LINE -> LineController.beginControl();
                    case STAMP -> StampController.beginControl();
                    case ERASER -> EraserController.beginControl();
                    case FILLER -> FillerController.beginControl();
                    case PENCIL -> PencilController.beginControl();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                switch (Hand.getInstrument()) {
                    case LINE -> LineController.finishControl();
                    case STAMP -> StampController.finishControl();
                    case ERASER -> EraserController.finishControl();
                    case FILLER -> FillerController.finishControl();
                    case PENCIL -> PencilController.finishControl();
                }
            }
        });
    }
}
