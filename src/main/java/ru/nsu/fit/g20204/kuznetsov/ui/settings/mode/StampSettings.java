package ru.nsu.fit.g20204.kuznetsov.ui.settings.mode;

import ru.nsu.fit.g20204.kuznetsov.ui.settings.SettingsLabel;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders.*;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields.*;

import javax.swing.*;
import java.util.List;

public class StampSettings {
    private static final SettingsLabel S = SettingsLabel.getInstance();

    public static void set() {
        S.removeAll();
        S.revalidate();
        controllersSet();
    }

    private static final List<BaseSlider> slidersList = List.of(
            WidthSlider.getInstance(),
            RotationSlider.getInstance(),
            RadiusSlider.getInstance(),
            PolygonSlider.getInstance()
    );

    private static final List<BaseTextField> textFieldsList = List.of(
            WidthTextField.getInstance(),
            RotationTextField.getInstance(),
            RadiusTextField.getInstance(),
            PolygonTopsTextField.getInstance()
    );

    private static final List<String> textLabelsList = List.of(
            "Width",
            "<html>Rotation<br/>angle</html>",
            "Radius",
            "<html>Tops</br>count</html>"
    );

    private static void controllersSet() {
        addAll();
        S.setSize(300 + S.getInsets().left + S.getInsets().right, 125 + S.getInsets().top + S.getInsets().bottom);
    }

    private static void addAll() {
        addSliders();
        addTextFields();
        addTextLabels();
    }

    private static void addTextLabels() {
        int i = 0;

        for (String text : textLabelsList) {
            JLabel textLabel = new JLabel(text);
            S.add(textLabel);
            textLabel.setBounds(280 + S.getInsets().left, 5 + (57 * i++) + S.getInsets().top, 200, 25);
        }
    }

    private static void addTextFields() {
        int i = 0;

        for (BaseTextField textField : textFieldsList) {
            S.add(textField);
            textField.setBounds(225 + S.getInsets().left, 5 + (57 * i++) + S.getInsets().top, 50, 25);
        }
    }

    private static void addSliders() {
        int i = 0;

        for (BaseSlider baseSlider : slidersList) {
            S.add(baseSlider);
            baseSlider.setBounds(S.getInsets().left, 5 + (55 * i++) + S.getInsets().top, 200, 50);
        }
    }
}
