package com.tcp.musicPlayer.model.notes;

public enum Notes {

    LA(69, "LA"),
    SI(71, "SI"),
    DO(60, "DO"),
    RE(62, "RE"),
    MI(64, "MI"),
    FA(65, "FA"),
    SOL(67, "SOL"),
    SIB(70, "SIB");

    private final int midiCode;
    private final String name;
    public static final int BASE_OCTAVE = 4;

    Notes(int midiCode, String name) {
        this.midiCode = midiCode;
        this.name = name;
    }

    public int getMidiCode() {
        return midiCode;
    }

    public String getName() {
        return name;
    }
}
