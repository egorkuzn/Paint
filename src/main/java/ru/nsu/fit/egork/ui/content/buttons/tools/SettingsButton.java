package ru.nsu.fit.egork.ui.content.buttons.tools;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingsButton extends ToolButton{
    public SettingsButton(int width, int height) {
        super(width, height, "tools/settings.png", "Settings");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                SettingsFrame.getInstance();
            }
        });
    }
}
