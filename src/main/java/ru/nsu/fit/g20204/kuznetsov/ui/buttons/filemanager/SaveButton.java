package ru.nsu.fit.g20204.kuznetsov.ui.buttons.filemanager;

import ru.nsu.fit.g20204.kuznetsov.ui.buttons.ToolButton;
import ru.nsu.fit.g20204.kuznetsov.util.FileExplorer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SaveButton extends ToolButton {
    public SaveButton() {
        super("tools/save.png", "Save image");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                FileExplorer.saveFile();
            }
        });
    }
}
