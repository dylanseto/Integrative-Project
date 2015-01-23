

package javafxgame2D.gameObjects.interfaces;

/**
 *
 * @author Ahmad El-Baher
 */
public interface Collidable 
{
    public double getLeft();
    
    public double getRight();
    
    public double getTop();
    
    public double getBottom();
    
    public boolean isCollision(Collidable other);
}
