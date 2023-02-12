package ru.nsu.fit.egork.ui.menu.help;

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
                        "There is instruction for Paint app",
                        "Instruction",
                        JOptionPane.PLAIN_MESSAGE);

            }
        });
    }
}
