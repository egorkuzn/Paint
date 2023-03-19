package ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public abstract class BaseTextField extends JTextField {

    public BaseTextField(int limit, int startValue) {
        setDocument(new LengthRestrictedDocument(limit));
        setFont(new Font("Consolas", Font.ITALIC, 14));
        setPreferredSize(new Dimension(30, 20));


        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int value = Integer.parseInt(getText());

                    if (value > limit || value < 0) {
                        value = limit / 4;
                    }

                    onRelease(value);
                }
            }
        });

        setText(String.valueOf(startValue));
    }

    public final static class LengthRestrictedDocument extends PlainDocument {

        private final int limit;

        public LengthRestrictedDocument(int limit) {
            this.limit = limit;
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if (str == null)
                return;

            if ((getLength() + str.length()) <= Math.log10(limit) + 1) {
                if (!str.matches("\\d+")) {
                    return;
                }

                if (Integer.parseInt(str) <= limit)
                    super.insertString(offs, str, a);
            }
        }
    }

    protected abstract void onRelease(int value);

    public void set(int value) {
        setText(String.valueOf(value));
    }
}
