

package javafxgame2D.mainGameElements;

import java.util.HashMap;
import javafx.scene.media.AudioClip;

/**
 *
 * @author Ahmad El-Baher
 */
public class SoundCollection 
{
    private static final HashMap<String, AudioClip> soundMap = new HashMap<>();
    
    public static AudioClip getSound(String strSoundName)
    {
        return soundMap.get(strSoundName);
    }
}
