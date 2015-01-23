
package javafxgame2D.mainGameElements;

import java.util.HashMap;
import javafx.scene.image.Image;

/**
 *
 * @author Ahmad El-Baher
 */
public class ImageCollection 
{
    private static final HashMap<String, Image> imageMap = new HashMap<>();
    
    public static Image getImage(String strImageName)
    {
        return imageMap.get(strImageName);
    }
}
