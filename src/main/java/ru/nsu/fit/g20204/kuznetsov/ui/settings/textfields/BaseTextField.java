package ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

public abstract class BaseTextField extends JTextField {
    static private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    int lowLimit = 0;

    public BaseTextField(int lowLimit, int highLimit, int startValue) {
        this.lowLimit = lowLimit;
        init(highLimit, startValue);
    }

    public BaseTextField(int limit, int startValue) {
        init(limit, startValue);
    }

    private void init(int highLimit, int startValue) {
        setDocument(new LengthRestrictedDocument(lowLimit, highLimit));
        setFont(new Font("Consolas", Font.ITALIC, 14));
        setPreferredSize(new Dimension(30, 20));


        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int value = Integer.parseInt(getText());

                    if (value > highLimit || value < lowLimit) {
                        value = lowLimit + (highLimit - lowLimit) / 4;
                    }

                    onRelease(value);
                }
            }
        });

        setText(String.valueOf(startValue));
    }

    public static final class LengthRestrictedDocument extends PlainDocument {
        private final int lowLimit;
        private final int highLimit;

        public LengthRestrictedDocument(int lowLimit, int highLimit) {
            this.lowLimit = lowLimit;
            this.highLimit = highLimit;
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if (str == null)
                return;

            if (lowLimit < 0 && !str.matches("//d+") && str.equals("-"))
                str = "-0";

            var maxNums = Math.max(Math.log10(Math.abs(lowLimit)) + 1, Math.log10(highLimit)) + 1;

            if ((getLength() + str.length()) <= maxNums) {
                try {
                    if (Integer.parseInt(str) <= highLimit && Integer.parseInt(str) >= lowLimit) {
                        super.insertString(offs, str, a);
                        return;
                    }

                    logger.info("Problem input 1");
                } catch (NumberFormatException e) {
                    logger.info("Problem input 2");
                } finally {
                    super.insertString(offs, "", a);
                }
            }
        }
    }

    protected abstract void onRelease(int value);

    public void set(int value) {
        setText(String.valueOf(value));
    }
}
