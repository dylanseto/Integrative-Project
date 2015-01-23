

package javafxgame2D.gameObjects.interfaces;

/**
 *
 * @author Ahmad El-Baher
 */
public interface IOrigin 
{
    public double getOriginX();
    
    public double getOriginY();
    
    public void setOriginX(double dOriginX);
    
    public  void setOriginY(double dOriginY);
    
    public void setOrigin(double dOriginX, double dOriginY);
    
    public  void setOriginAtCenter();
    
    public double getOriginPointX();
    
    public void setOriginPointX(double dX);
    
    public double getOriginPointY();
    
    public  void setOriginPointY(double dY);
    
    public void setPosition(double dX, double dY);
}
