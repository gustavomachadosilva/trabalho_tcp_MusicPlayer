package com.tcp.musicPlayer.model.notes;

public enum Notes {

    LA(69),
    SI(71),
    DO(60),
    RE(62),
    MI(64),
    FA(65),
    SOL(67),
    SIB(70);


    private final int midiCode;
    public static final int BASE_OCTAVE = 4;

    Notes(int midiCode) {
        this.midiCode = midiCode;
    }

    public int getMidiCode() {
        return midiCode;
    }
}
