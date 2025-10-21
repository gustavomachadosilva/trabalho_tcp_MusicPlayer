package model.inputHandlers;
import static model.inputHandlers.Constants.*;

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

    public char getNextChar() {

        if ( this.hasNextChar()) {
            char nextChar = this.text.charAt(currentChar);

            this.currentChar += 1;
            return nextChar;
        }

        return TEXT_END;

    }

    public boolean hasNextChar() {
        return this.currentChar < this.text.length();
    }

}
