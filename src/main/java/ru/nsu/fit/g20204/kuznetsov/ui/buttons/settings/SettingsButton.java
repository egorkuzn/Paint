package ru.nsu.fit.g20204.kuznetsov.ui.buttons.settings;

import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.SettingsFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingsButton extends ToolButton {
    public SettingsButton() {
        super("tools/settings.png", "Settings");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                SettingsFrame.getInstance();
            }
        });
    }
}
