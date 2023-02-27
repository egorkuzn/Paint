package ru.nsu.fit.egork.ui.content.buttons.textfields;

import ru.nsu.fit.egork.Hand;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PolygonTopsTextField extends BaseTextField {
    private static PolygonTopsTextField polygonTopsTextField = null;
    private static final int limit = 100;

    public PolygonTopsTextField() {
        super(limit);
        setText(String.valueOf(Hand.getTopsCount()));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int value = Integer.parseInt(getInstance().getText());

                    if (value > limit || value < 0) {
                        value = 50;
                    }

                    Hand.setTopsCount(value);
                }
            }
        });
    }

    public static PolygonTopsTextField getInstance() {
        if (polygonTopsTextField == null) {
            polygonTopsTextField = new PolygonTopsTextField();
        }

        return polygonTopsTextField;
    }

    public static void set(int value) {
        getInstance().setText(String.valueOf(value));
    }
}
