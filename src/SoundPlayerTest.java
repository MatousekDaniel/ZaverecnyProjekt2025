import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoundPlayerTest {

    /**
     * Tests if the volume is in valid range and updates correctly.
     */
    @Test
    void testSetVolumeWithinRange() {
        SoundPlayer.setVolume(50);
        assertEquals(50, SoundPlayer.getVolume());
    }

    /**
     * Tests if the volume is capped at 100 and updates correctly.
     */
    @Test
    void testSetVolumeTooHigh() {
        SoundPlayer.setVolume(150);
        assertEquals(100, SoundPlayer.getVolume());
    }

    /**
     * Tests if the volume is capped at 0 and updates correctly.
     */
    @Test
    void testSetVolumeTooLow() {
        SoundPlayer.setVolume(-50);
        assertEquals(0, SoundPlayer.getVolume());
    }
}