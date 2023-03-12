package ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.util.logging.Logger;

public class BaseTextField extends JTextField {
    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public BaseTextField(int limit) {
        setDocument(new LengthRestrictedDocument(limit));
        setFont(new Font("Consolas", Font.ITALIC, 14));
        setPreferredSize(new Dimension(30, 20));
    }

    public final class LengthRestrictedDocument extends PlainDocument {

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
}
