package ru.nsu.fit.g20204.kuznetsov.ui.settings.mode;

import ru.nsu.fit.g20204.kuznetsov.ui.settings.SettingsLabel;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders.WidthSlider;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields.WidthTextField;

import javax.swing.*;

public class WidthSettings {

    private static final SettingsLabel S = SettingsLabel.getInstance();

    public static void set() {
        S.removeAll();
        S.revalidate();

        JLabel widthTextLabel = new JLabel("Width");

        S.add(WidthSlider.getInstance());
        S.add(WidthTextField.getInstance());
        S.add(widthTextLabel);

        WidthSlider.getInstance().setBounds(S.getInsets().left, 5 + S.getInsets().top, 200, 50);
        WidthTextField.getInstance().setBounds(225 + S.getInsets().left, 5 + S.getInsets().top, 50, 25);
        widthTextLabel.setBounds(280 + S.getInsets().left, 5 + S.getInsets().top, 200, 25);
    }
}
