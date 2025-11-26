package model;

import com.tcp.musicPlayer.model.RequestMusic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestMusicTest {

    @Test
    void testConstructorSetsValuesCorrectly() {
        RequestMusic request = new RequestMusic("ABC", 120, 80, 4);

        assertEquals("ABC", request.getInput());
        assertEquals(120, request.getBpm());
        assertEquals(80, request.getVolume());
        assertEquals(4, request.getOctave());
    }

    @Test
    void testSettersAndGetters() {
        RequestMusic request = new RequestMusic("", 0, 0, 0);

        request.setInput("XYZ");
        request.setBpm(140);
        request.setVolume(95);
        request.setOctave(6);

        assertEquals("XYZ", request.getInput());
        assertEquals(140, request.getBpm());
        assertEquals(95, request.getVolume());
        assertEquals(6, request.getOctave());
    }
}
