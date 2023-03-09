package ru.nsu.fit.g20204.kuznetsov.ui.menu.help;

import ru.nsu.fit.egork.ui.MainFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

public class Instruction extends JMenuItem {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Instruction() {
        super("Instruction");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                logger.info("Instruction dialog window");
                JOptionPane.showMessageDialog(MainFrame.getInstance(),
                        """
                                Simple paint app for 2D objects drawing by pencil, straight lines, fill and stamps.\n
                                It's works pretty simple: by default your mouse is used like pencil that draw when
                                the left mouse .
                                                               
                                For line: click on line image, click and press left mouse button in the draw space.
                                And when it would be ready - release mouse.
                                
                                For erase: chose erase on tool bar and manipulate it like pensil.                                
                                
                                For fill: click on the drawing space and then chosen region will change color on 
                                current color.
                                
                                Color pallet: you also can find it among tools. Different color schemas allow to
                                chose current color between different colors.
                                
                                Stamps divided from other instruments by vertical line. To use stamp: click on some
                                stamp and then click on the drawing area for visualising. This figure can be change
                                by settings parameters. If you set it just click on the drawing area. Choose regular
                                polygon or regular star.
                                
                                Settings button: it opens window for choosing:
                                *   Width
                                *   Rotation angle (for stamp)
                                *   Radius (for stamp)
                                *   Polygon tops count (for stamp)
                                
                                Enjoy my app! https://github.com/egorkuzn/Paint
                                """,
                        "Instruction",
                        JOptionPane.PLAIN_MESSAGE);

            }
        });
    }
}
