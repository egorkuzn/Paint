package ru.nsu.fit.g20204.kuznetsov.ui.settings;

import ru.nsu.fit.g20204.kuznetsov.ui.settings.sliders.BaseSlider;
import ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields.BaseTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SettingsLabel extends JLabel {
    private List<BaseSlider> slidersList = new ArrayList<>();
    private List<BaseTextField> textFieldsList = new ArrayList<>();
    private List<String> textLabelsList = new ArrayList<>();
    private static SettingsLabel settingsLabel = null;

    private SettingsLabel() {
        defaultSet();
        controllersSet();
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

    private void controllersSet() {
        addAll();
        setSize(300 + getInsets().left + getInsets().right, 125 + getInsets().top + getInsets().bottom);
    }

    private void addAll() {
        addSliders();
        addTextFields();
        addTextLabels();
    }

    private void addTextLabels() {
        int i = 0;

        for (String text : textLabelsList) {
            JLabel textLabel = new JLabel(text);
            add(textLabel);
            textLabel.setBounds(280 + getInsets().left, 5 + (55 * i++) + getInsets().top, 200, 50);
        }
    }

    private void addTextFields() {
        int i = 0;

        for (BaseTextField textField : textFieldsList) {
            add(textField);
            textField.setBounds(225 + getInsets().left, 5 + (55 * i++) + getInsets().top, 50, 50);
        }
    }

    private void addSliders() {
        int i = 0;

        for (BaseSlider baseSlider : slidersList) {
            add(baseSlider);
            baseSlider.setBounds(getInsets().left, 5 + (55 * i++) + getInsets().top, 400, 50);
        }
    }

    public void setContentLists(List<BaseSlider> slidersList, List<BaseTextField> textFieldsList, List<String> textLabelsList) {
        this.slidersList = slidersList;
        this.textFieldsList = textFieldsList;
        this.textLabelsList = textLabelsList;
    }
}
