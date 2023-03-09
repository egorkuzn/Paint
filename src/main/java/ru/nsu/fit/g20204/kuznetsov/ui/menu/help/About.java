package ru.nsu.fit.g20204.kuznetsov.ui.menu.help;

import ru.nsu.fit.g20204.kuznetsov.ui.MainFrame;

import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Logger;

public class About extends JMenuItem {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public About() {
        super("About");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                logger.info("About dialog window");
                JOptionPane.showMessageDialog(MainFrame.getInstance(),
                        "This work was made by Yegor Kuznetsov NSU, FIT 2023",
                        "About",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
