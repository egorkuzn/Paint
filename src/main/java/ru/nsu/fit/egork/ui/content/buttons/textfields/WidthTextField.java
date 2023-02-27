package ru.nsu.fit.egork.ui.content.buttons.textfields;

import ru.nsu.fit.egork.Hand;
import ru.nsu.fit.egork.History;

import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WidthTextField extends BaseTextField {
    private static WidthTextField widthTextField = null;
    private static final int limit = 10;

    private WidthTextField() {
        super(10);
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
