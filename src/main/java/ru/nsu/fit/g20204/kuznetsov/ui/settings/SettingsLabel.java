package ru.nsu.fit.g20204.kuznetsov.ui.settings;

import javax.swing.*;
import java.awt.*;

public class SettingsLabel extends JLabel {
    private static SettingsLabel settingsLabel = null;

    private SettingsLabel() {
        defaultSet();
        setLayout(null);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    public static SettingsLabel getInstance() {
        if (settingsLabel == null) {
            settingsLabel = new SettingsLabel();
        }

        settingsLabel.setVisible(true);

        return settingsLabel;
    }

    void defaultSet() {
        setMinimumSize(new Dimension(380, 260));
        setSize(new Dimension(380, 260));
        setPreferredSize(new Dimension(380, 260));
        setLocation(100, 100);
    }
}
