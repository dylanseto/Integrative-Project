

package javafxgame2D.gameObjects;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This class will be extended by other classes whose purpose is to be displayed as text objects on screen.
 * Contains a constructor that calls the Text's constructor and sets its font.
 * @author Ahmad El-Baher
 */
public class TextGameObject extends Text
{   
    /**
     * Constructs the class and sets its position according to the specified coordinates, then sets its font.
     * @param dX The x-position of the text.
     * @param dY The y-position of the text.
     * @param strText The text of this object (what is actually displayed).
     * @param font The font of the text.
     */
    public TextGameObject(double dX, double dY, String strText, Font font)
    {
        super(dX, dY, strText);
        setFont(font);
    }
}
