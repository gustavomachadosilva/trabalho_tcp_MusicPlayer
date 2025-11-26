package model;

import com.tcp.musicPlayer.model.Volume;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

public class VolumeTest extends TestCase {
    Volume volume = new Volume(5, 10);

    @Test
    public void testConstructorSetsValueCorrectly() {
        assertNotNull("O volume atual deve ser inicializado", volume.getCurrentVolume());
        assertNotNull("O volume maximo deve ser inicializado", volume.getMaxVolume());
    }
    @Test
    public void testGetCurrentVolumeEqualsFive() {
        assertEquals("O volume atual deve ser 5", 5, volume.getCurrentVolume());
    }

    @Test
    public void testSetCurrentVolumeToSix() {
        volume.setCurrentVolume(6);
        assertEquals("O volume atual deve ser 6",6, volume.getCurrentVolume());
    }

    @Test
    public void testGetMaxVolumeEqualsEqualsTen() {
        assertEquals("O volume maximo deve ser 10", 10, volume.getMaxVolume());
    }

    @Test
    public void testSetMaxVolumeToSix() {
        volume.setMaxVolume(6);
        assertEquals("O volume maximo deve ser 6", 6, volume.getMaxVolume());
    }
}