package ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields;


import ru.nsu.fit.g20204.kuznetsov.Hand;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RadiusTextField extends BaseTextField {
    private static RadiusTextField radiusTextField = null;
    private static final int limit = 1000;

    public RadiusTextField() {
        super(limit);
        setText(String.valueOf(Hand.getRadius()));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int value = Integer.parseInt(getInstance().getText());

                    if (value > limit || value < 0) {
                        value = 500;
                    }

                    Hand.setRadius(value);
                }
            }
        });
    }

    public static RadiusTextField getInstance() {
        if (radiusTextField == null) {
            radiusTextField = new RadiusTextField();
        }

        return radiusTextField;
    }

    public static void set(int value) {
        getInstance().setText(String.valueOf(value));
    }
}
