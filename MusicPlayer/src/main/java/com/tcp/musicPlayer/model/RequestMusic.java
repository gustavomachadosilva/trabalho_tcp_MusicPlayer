package com.tcp.musicPlayer.model;

public class RequestMusic {

    private String input;
    private int bpm;
    private int volume;
    private int octave;

    public RequestMusic(String input, int bpm, int volume, int octave) {
        this.input = input;
        this.bpm = bpm;
        this.volume = volume;
        this.octave = octave;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getOctave() {
        return octave;
    }

    public void setOctave(int octave) {
        this.octave = octave;
    }
}
