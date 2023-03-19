package ru.nsu.fit.g20204.kuznetsov.instruments;

public enum InstrumentType {
    PENCIL,
    LINE,
    FILLER,
    ERASER,
    STAMP,
    FILTER,
    HAND;

    public boolean isSettable() {
        return !(this == HAND || this == FILLER);
    }
}
