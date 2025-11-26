package model.inputHandlers;

import com.tcp.musicPlayer.model.inputHandlers.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextHandlerTest {

    @Test
    void testHasNextCharQuandoVazio() {
        TextHandler handler = new TextHandler("");
        assertFalse(handler.hasNextChar());
    }

    @Test
    void testHasNextCharComTexto() {
        TextHandler handler = new TextHandler("ABC");
        assertTrue(handler.hasNextChar());
        handler.getNextChar();
        assertTrue(handler.hasNextChar());
        handler.getNextChar();
        handler.getNextChar();
        assertFalse(handler.hasNextChar());
    }

    @Test
    void testGetNextCharRetornaCaracteresNormais() {
        TextHandler handler = new TextHandler("XYZ");

        assertEquals("X", handler.getNextChar());
        assertEquals("Y", handler.getNextChar());
        assertEquals("Z", handler.getNextChar());
    }

    @Test
    void testGetNextCharRetornaTEXT_ENDAoFinal() {
        TextHandler handler = new TextHandler("A");

        assertEquals("A", handler.getNextChar());
        assertEquals(Constants.TEXT_END, handler.getNextChar());
    }

    @Test
    void testReconheceTokenBPM() {
        TextHandler handler = new TextHandler("BPM+ABC");

        assertEquals("BPM+", handler.getNextChar()); // detectou token
        assertEquals("A", handler.getNextChar());    // continua fluxo normal
        assertEquals("B", handler.getNextChar());
        assertEquals("C", handler.getNextChar());
    }

    @Test
    void testLetraBQueNaoFormaBPM() {
        TextHandler handler = new TextHandler("BAAA");

        assertEquals("B", handler.getNextChar());   // não vira BPM+
        assertEquals("A", handler.getNextChar());
    }

    @Test
    void testTokenBPMNoMeioDaString() {
        TextHandler handler = new TextHandler("XTBPM+Y");

        assertEquals("X", handler.getNextChar());
        assertEquals("T", handler.getNextChar());
        assertEquals("BPM+", handler.getNextChar());
        assertEquals("Y", handler.getNextChar());
    }

    @Test
    void testBNoFinalNaoDeveVirarBPM() {
        TextHandler handler = new TextHandler("AB");

        assertEquals("A", handler.getNextChar());
        assertEquals("B", handler.getNextChar()); // B sozinho no final
        assertEquals(Constants.TEXT_END, handler.getNextChar());
    }
}
