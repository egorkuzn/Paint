package ru.nsu.fit.g20204.kuznetsov.ui.settings.textfields;


import ru.nsu.fit.g20204.kuznetsov.Hand;

public class WidthTextField extends BaseTextField {
    private static WidthTextField widthTextField = null;
    private static final int limit = 100;

    private WidthTextField() {
        super(limit, Hand.getWidth());
    }

    public static WidthTextField getInstance() {
        if (widthTextField == null) {
            widthTextField = new WidthTextField();
        }

        return widthTextField;
    }

    @Override
    protected void onRelease(int value) {
        Hand.setWidth(value);
    }
}
