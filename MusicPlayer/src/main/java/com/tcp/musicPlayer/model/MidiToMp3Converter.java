package com.tcp.musicPlayer.model;

import java.io.File;

public class MidiToMp3Converter {

    public static void convertMidiToMp3(File midi, File mp3) throws Exception {

        File wav = new File("temp.wav");

        // converter MIDI → WAV
        ProcessBuilder timidity = new ProcessBuilder(
                "timidity", midi.getAbsolutePath(), "-Ow", "-o", wav.getAbsolutePath()
        );
        timidity.start().waitFor();

        // converter WAV → MP3
        ProcessBuilder lame = new ProcessBuilder(
                "lame", wav.getAbsolutePath(), mp3.getAbsolutePath()
        );
        lame.start().waitFor();

        wav.delete();
    }

}
