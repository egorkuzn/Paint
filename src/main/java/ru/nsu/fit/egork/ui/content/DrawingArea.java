package ru.nsu.fit.egork.ui.content;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.History;
import ru.nsu.fit.egork.controllers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.logging.Logger;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class DrawingArea extends JPanel {
    private static DrawingArea drawingArea = null;
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private DrawingArea() {
        super(new BorderLayout());
        setMouseListener();
        setBackground(Color.WHITE);
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

        removeAll();
        validate();
        repaint();

        if (!History.getScreens().isEmpty()) {
            g.drawImage(History.getLastScreen(), 0, 0, this);
        }

        switch (Hand.getInstrument()) {
            case LINE -> LineController.paint(g);
            case STAMP -> StampController.paint(g);
            case ERASER -> EraserController.paint(g);
            case FILLER -> FillerController.paint(g);
            case PENCIL -> PencilController.paint(g);
        }
    }

    private void setMouseListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                switch (Hand.getInstrument()) {
                    case LINE -> LineController.beginControl(e.getPoint());
                    case STAMP -> StampController.beginControl();
                    case ERASER -> EraserController.beginControl();
                    case FILLER -> FillerController.beginControl();
                    case PENCIL -> PencilController.beginControl(e.getPoint());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                switch (Hand.getInstrument()) {
                    case LINE -> LineController.finishControl(e.getPoint());
                    case STAMP -> StampController.finishControl();
                    case ERASER -> EraserController.finishControl();
                    case FILLER -> FillerController.finishControl();
                    case PENCIL -> PencilController.finishControl(e.getPoint());
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                switch (Hand.getInstrument()) {
                    case LINE -> {LineController.mediumControl(e.getPoint());
                        logger.info("MOVED");
                    }
                    case STAMP -> StampController.mediumControl();
                    case ERASER -> EraserController.mediumControl();
                    case FILLER -> FillerController.mediumControl();
                    case PENCIL -> PencilController.mediumControl(e.getPoint());
                }
            }
        });
    }

    public static void takeSnapshot() {
        BufferedImage img = new BufferedImage(getInstance().getWidth(), DrawingArea.getInstance().getHeight(), TYPE_INT_RGB);
        getInstance().print(img.getGraphics());
        History.saveScreen(img);
    }
}
