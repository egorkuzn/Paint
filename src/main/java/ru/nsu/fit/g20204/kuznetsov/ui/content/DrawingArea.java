package ru.nsu.fit.g20204.kuznetsov.ui.content;

import ru.nsu.fit.g20204.kuznetsov.Hand;
import ru.nsu.fit.g20204.kuznetsov.History;
import ru.nsu.fit.g20204.kuznetsov.controllers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.logging.Logger;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class DrawingArea extends JPanel {
    private static DrawingArea drawingArea = null;
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private DrawingArea() {
        super();
        setMouseListener();
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(History.getMaxWidth(), History.getMaxHeight()));
    }

    public static DrawingArea getInstance() {
        if (drawingArea == null) {
            drawingArea = new DrawingArea();
        }

        return drawingArea;
    }

    /**
     * <code>paintComponent</code> draws last saved image
     * on the board and adds 2d graphics
     * @param g the <code>Graphics</code> object that
     * allows to visualise 2d primitives.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        removeAll();
        validate();
        repaint();

        if (!History.getScreens().isEmpty()) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, History.getMaxWidth(), History.getMaxHeight());
            g.drawImage(History.getLastScreen(), 0, 0, History.getLastScreen().getWidth(), History.getLastScreen().getHeight(), this);
        }

        switch (Hand.getInstrument()) {
            case LINE -> LineController.paint(g);
            case STAMP -> StampController.paint(g);
            case ERASER -> EraserController.paint(g);
            case FILLER -> FillerController.paint(g);
            case PENCIL -> PencilController.paint(g);
            default -> {
            }
            // TODO: case FILTER ->
        }
    }

    private void setMouseListener() {
        addMouseListener(new MouseAdapter() {
            /**
             * When you want catch the start of mouse pressing.
             * Use <code>.beginControl()</code> method for your
             * controller
             */
            @Override
            public void mousePressed(MouseEvent e) {
                switch (Hand.getInstrument()) {
                    case LINE -> LineController.beginControl(e.getPoint());
                    case STAMP -> StampController.beginControl(e.getPoint());
                    case ERASER -> EraserController.beginControl(e.getPoint());
                    case FILLER -> FillerController.beginControl(e.getPoint());
                    case PENCIL -> PencilController.beginControl(e.getPoint());
                    default -> {
                    }
                    // TODO: case FILTER ->
                }
            }

            /**
             * When you want catch the finish of mouse pressing.
             * Use <code>.finishControl()</code> method for your
             * controller
             */
            @Override
            public void mouseReleased(MouseEvent e) {
                switch (Hand.getInstrument()) {
                    case LINE -> LineController.finishControl(e.getPoint());
                    case STAMP -> StampController.finishControl(e.getPoint());
                    case ERASER -> EraserController.finishControl(e.getPoint());
                    case FILLER -> FillerController.finishControl();
                    case PENCIL -> PencilController.finishControl(e.getPoint());
                    default -> {
                    }
                    // TODO: case FILTER ->
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            /**
             * When you want catch the mouse in motion.
             * Use <code>.mediumControl()</code> method for your
             * controller
             */
            @Override
            public void mouseDragged(MouseEvent e) {
                switch (Hand.getInstrument()) {
                    case LINE -> {
                        LineController.mediumControl(e.getPoint());
                        logger.info("MOVED");
                    }
                    case STAMP -> StampController.mediumControl();
                    case ERASER -> EraserController.mediumControl(e.getPoint());
                    case FILLER -> FillerController.mediumControl();
                    case PENCIL -> PencilController.mediumControl(e.getPoint());
                    default -> {
                    }
                    // TODO: case FILTER ->
                }
            }
        });
    }

    /**
     * Use this method to take screen snapshot.
     * After this method, board will be saved in <code>History</code>
     * and user can make undo action
     */
    public static void takeSnapshot() {
        BufferedImage img = new BufferedImage(getInstance().getWidth(), DrawingArea.getInstance().getHeight(), TYPE_INT_RGB);
        getInstance().print(img.getGraphics());
        History.saveScreen(img);
    }
}
