package ru.nsu.fit.egork.ui.content.buttons.textfields;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.History;
import ru.nsu.fit.egork.ui.content.buttons.sliders.RotationChooseSlider;

import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RotationTextField extends BaseTextField {
    private static RotationTextField rotationTextField = null;
    private static final int limit = 360;

    private RotationTextField() {
        super(limit);
        setText(String.valueOf(Hand.getAngleDegreese()));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int value = Integer.parseInt(getInstance().getText());

                    if (value > limit || value < 0) {
                        value = 180;
                    }

                    Hand.setAngle(value);
                }
            }
        });
    }

    public static RotationTextField getInstance() {
        if (rotationTextField == null) {
            rotationTextField = new RotationTextField();
        }

        return rotationTextField;
    }


    public static void set(int value) {
        getInstance().setText(String.valueOf(value));
    }
}
