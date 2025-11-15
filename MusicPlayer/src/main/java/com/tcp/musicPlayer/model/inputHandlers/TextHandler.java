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
                char[] charArray = new char[0];

                if ((currentChar + 3) <= this.text.length()) {
                    this.text.getChars(currentChar, currentChar + 3, charArray, 0);
                }

                if (String.valueOf(charArray).equals("BPM+")) {
                    nextChar = "BPM+";
                    currentChar += 3;
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
