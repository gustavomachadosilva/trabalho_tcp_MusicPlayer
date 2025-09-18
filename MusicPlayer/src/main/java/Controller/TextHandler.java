package Controller;

public class TextHandler {

    private String text;
    private int currentChar;

    public TextHandler(String text) {
        this.text = text;
        this.currentChar = 0;
    }

    public char getNextChar() {
        char nextChar = '0';

        if (hasNextChar()) {
            nextChar = text.charAt(currentChar);
            currentChar++;
        }

        return nextChar;
    }

    public boolean hasNextChar() {

        boolean hasNextChar = false;

        if ((currentChar <= (text.length() - 1)) && (currentChar >= 0)) {
            hasNextChar = true;
        }

        return hasNextChar;
    }
}
