package com.tcp.musicPlayer.model.inputHandlers;
import static com.tcp.musicPlayer.model.inputHandlers.Constants.*;

public class TextHandler {

    private String text;
    private int  currentChar;

    public TextHandler(String text) {

        this.text = text;
        this.currentChar = 0;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNextChar() {

        String nextChar = TEXT_END;

        if ( this.hasNextChar()) {
            nextChar = String.valueOf(this.text.charAt(currentChar));

            if (nextChar.equals("B")) {
                String testBPM = "";

                if ((currentChar + 4) <= this.text.length()) {
                    testBPM = this.text.substring(currentChar, currentChar+4);
                }

                if (testBPM.equals("BPM+")) {
                    nextChar = "BPM+";
                    currentChar += 4;
                    return nextChar;
                }
            }

            this.currentChar += 1;
        }

        return nextChar;

    }

    public boolean hasNextChar() {
        return this.currentChar < this.text.length();
    }

}
