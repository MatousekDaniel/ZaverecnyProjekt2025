import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class SoundPlayer is responsible for decoding and playing audio files.
 */
public class SoundPlayer {
    /**
     * Default volume is set to 50.
     */
    private static int volume = 50;

    /**
     * Sets the playback volume and makes sure its capped between 0 - 100
     * @param percent
     */
    public static void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
    }

    /**
     * Plays audio files from specific resource path, decodes audio files and adjusts volume.
     * Code not made by me (written with the help of ChatGPT) is marked with /* + *
     *
     * @param resourcePath - path to the audio file.
     */
    public static void play(String resourcePath) {
        try {
            InputStream audioSrc = SoundPlayer.class.getResourceAsStream(resourcePath);
            if (audioSrc == null) {
                System.err.println("Audio resource not found: " + resourcePath);
                return;
            }
            BufferedInputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn); // Opens and reads the Audio file
            Clip clip = AudioSystem.getClip(); // Creates a clip for the file
            clip.open(audioStream); // Loads in the date from AudiiInputSteam to clip


            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {                                 /* + */
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN); /* + */

                float min = gainControl.getMinimum();                                                     /* + */
                float max = gainControl.getMaximum();                                                     /* + */

                float range = max - min;                                                                  /* + */
                float gain;                                                                               /* + */
                if (volume == 0) {                                                                        /* + */
                    gain = min;                                                                           /* + */
                } else {                                                                                  /* + */
                    float volumeFactor = (float) volume / 100f;                                           /* + */
                    gain = (float) (20f * Math.log10(volumeFactor));                                      /* + */
                    gain = Math.max(min, Math.min(max, gain));                                            /* + */
                }
                gainControl.setValue(gain);                                                               /* + */

                gainControl.setValue(gain);                                                               /* + */
            }

            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter for volume
     * @return volume
     */
    public static int getVolume() {
        return volume;
    }
}