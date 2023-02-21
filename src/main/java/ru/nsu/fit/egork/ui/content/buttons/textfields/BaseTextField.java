package ru.nsu.fit.egork.ui.content.buttons.textfields;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

public class BaseTextField extends JTextField {
    public BaseTextField() {
        super("10");
        setFont(new Font("Consolas", Font.ITALIC, 14));
    }
}
