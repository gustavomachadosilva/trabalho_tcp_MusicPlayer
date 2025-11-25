package model;

import com.tcp.musicPlayer.model.BPM;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

public class BPMTest extends TestCase {

    private BPM bpm = new BPM(120);

    @Test
    public void testConstructorSetsValueCorrectly() {
        assertEquals("O construtor deve definir corretamente o valor do BPM", 120, bpm.getValue());
    }

    @Test
    public void testSetValueChangesBpm() {
        bpm.setValue(140);
        assertEquals("setValue deve alterar o valor do BPM", 140, bpm.getValue());
    }

    @Test
    public void testGetValueReturnsCurrentBpm() {
        bpm.setValue(90);
        int current = bpm.getValue();
        assertEquals("getValue deve retornar o BPM atual", 90, current);
    }
}