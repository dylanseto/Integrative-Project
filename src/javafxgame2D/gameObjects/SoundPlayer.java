

package javafxgame2D.gameObjects;

import javafx.scene.media.AudioClip;

/**
 * Plays a sound using a static method.
 * @author Ahmad El-Baher
 */
public class SoundPlayer 
{
    private static AudioClip audioClip;
    
    /**
     * Plays a sound from the specified URL.
     * @param strUrl The URL to get the sound from.
     */
    public static void playSound(String strUrl)
    {
        audioClip = new AudioClip(strUrl);
        audioClip.play();
    }
    
    /**
     * Plays a sound using the specified audio clip.
     * @param sound The audio clip to play.
     */
    public static void playSound(AudioClip sound)
    {
        audioClip = sound;
        audioClip.play();
    }

}
