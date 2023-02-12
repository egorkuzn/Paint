package ru.nsu.fit.egork.ui.content.buttons.instruments;

import ru.nsu.fit.egork.Hand;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

public class Palette extends JColorChooser {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    Palette() {
        super();
        logger.info("Palette created");

        getSelectionModel().addChangeListener(new ChangeListener() {
                                                  @Override
                                                  public void stateChanged(ChangeEvent e) {
                                                      logger.info("Pallet color chosen " + getColor());
                                                      Hand.changeColor(getColor());
                                                  }
                                              });
    }
}
