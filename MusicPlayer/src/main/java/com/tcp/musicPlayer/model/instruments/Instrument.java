package com.tcp.musicPlayer.model.instruments;

public class Instrument {

    private String name;
    private int midiCode;

    public Instrument(Instruments instrument) {
        changeInstrument(instrument);
    }

    public String getName() {
        return name;
    }

    public int getMidiCode() {
        return midiCode;
    }

    public void changeInstrument(Instruments instrument) {
        this.name = instrument.getName();
        this.midiCode = instrument.getMidiCode();
    }
}
