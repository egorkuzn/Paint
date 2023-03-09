package ru.nsu.fit.g20204.kuznetsov.ui.content.buttons.textfields;


import ru.nsu.fit.g20204.kuznetsov.Hand;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WidthTextField extends BaseTextField {
    private static WidthTextField widthTextField = null;
    private static final int limit = 100;

    private WidthTextField() {
        super(limit);
        setText(String.valueOf(Hand.getWidth()));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int value = Integer.parseInt(getInstance().getText());

                    if (value > limit || value < 0) {
                        value = 1;
                    }

                    Hand.setWidth(value);
                }
            }
        });
    }

    public static WidthTextField getInstance() {
        if (widthTextField == null) {
            widthTextField = new WidthTextField();
        }

        return widthTextField;
    }

    public static void set(int value) {
        getInstance().setText(String.valueOf(value));
    }
}
