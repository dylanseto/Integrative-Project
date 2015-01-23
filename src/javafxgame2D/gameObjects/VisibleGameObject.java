

package javafxgame2D.gameObjects;

import javafxgame2D.gameObjects.interfaces.Collidable;
import javafxgame2D.gameObjects.interfaces.IOrigin;
import javafxgame2D.gameObjects.interfaces.Moveable;
import javafxgame2D.gameObjects.interfaces.Resizable;
import javafxgame2D.gameObjects.interfaces.Rotatable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

/**
 * This class is used as a generic sprite object that represents a visible game object. Has many useful methods to move, rotate,
 * resize, change its image, and many other useful game functions.
 * @author Ahmad El-Baher
 */
public abstract class VisibleGameObject extends ImageView implements Collidable, Moveable, Resizable, IOrigin, Rotatable
{
    private double m_dOriginX;
    private double m_dOriginY;
    
    /**
     * Constructs this visible game object with the specified image and the origin set to the top left corner of the object.
     * @param spriteImage The image of the object.
     */
    public VisibleGameObject(Image spriteImage)
    {
        this(spriteImage, 0.0, 0.0);
    }
    
    /**
     * Constructs this visible game object with the specified image and origin coordinates (relative to the object).
     * It also sets the fit width and height to the width and height of the image.
     * @param spriteImage The image of the object.
     * @param dOriginX The x-coordinate of this object's origin.
     * @param dOriginY The y-coordinate of this object's origin.
     */
    public VisibleGameObject(Image spriteImage, double dOriginX, double dOriginY)
    {
        setImage(spriteImage);
        setOrigin(dOriginX, dOriginY);
        setSize(getImage().getWidth(), getImage().getHeight());
    }
    
    /**
     * Gets the (fit) width of this object.
     * @return The (fit) width of this object.
     */
    @Override
    public double getWidth()
    {
        return getFitWidth();
    }
    
    /**
     * Gets the (fit) height of this object.
     * @return The (fit) height of this object.
     */
    @Override
    public double getHeight()
    {
        return getFitHeight();
    }
    
    /**
     * Sets the (fit) width of this object.
     * @param dWidth The (fit) width of this object.
     */
    @Override
    public void setWidth(double dWidth)
    {
        setFitWidth(dWidth);
    }
    
    /**
     * Sets the (fit) height of this object.
     * @param dHeight The (fit) height of this object.
     */
    @Override
    public void setHeight(double dHeight)
    {
        setFitHeight(dHeight);
    }
    
    /**
     * Sets both the (fit) width and height of this object.
     * @param dWidth The (fit) width of this object.
     * @param dHeight The (fit) height of this object.
     */
    @Override
    public void setSize(double dWidth, double dHeight)
    {
        setFitWidth(dWidth);
        setFitHeight(dHeight);
    }
    
    /**
     * Gets the x-coordinate of the origin of this object.
     * @return The x-coordinate of the origin of this object.
     */
    @Override
    public double getOriginX()
    {
        return m_dOriginX;
    }
    
    /**
     * Gets the y-coordinate of the origin of this object.
     * @return The y-coordinate of the origin of this object.
     */
    @Override
    public double getOriginY()
    {
        return m_dOriginY;
    }
    
    /**
     * Sets the x-coordinate of the origin of this object.
     * @param dOriginX The x-coordinate of the origin of this object to set.
     */
    @Override
    public void setOriginX(double dOriginX)
    {
        m_dOriginX = dOriginX;
    }
    
    /**
     * Sets the y-coordinate of the origin of this object.
     * @param dOriginY The y-coordinate of the origin of this object to set.
     */
    @Override
    public  void setOriginY(double dOriginY)
    {
        m_dOriginY = dOriginY;
    }
    
    /**
     * Sets the origin of this object.
     * @param dOriginX The x-coordinate of the origin of this object to set.
     * @param dOriginY The y-coordinate of the origin of this object to set.
     */
    @Override
    public void setOrigin(double dOriginX, double dOriginY)
    {
        setOriginX(dOriginX);
        setOriginY(dOriginY);
    }
    
    /**
     * Sets the origin of the object directly in its center.
     */
    @Override
    public  void setOriginAtCenter()
    {
        setOrigin(getWidth()/2, getHeight()/2);
    }
    
    /**
     * Gets the x-coordinate of this object while taking the origin to account.
     * @return The x-coordinate of this object while taking the origin to account.
     */
    @Override
    public double getOriginPointX()
    {
        return getX() - getOriginX();
    }
    
    /**
     * Sets the x-coordinate of this object while taking the origin to account.
     * @param dX The x-coordinate to set.
     */
    @Override
    public void setOriginPointX(double dX)
    {
        setX(dX - getOriginX());
    }
    
    /**
     * Gets the y-coordinate of this object while taking the origin to account.
     * @return The y-coordinate of this object while taking the origin to account.
     */
    @Override
    public double getOriginPointY()
    {
        return getY() - getOriginY();
    }
    
    /**
     * Sets the y-coordinate of this object while taking the origin to account.
     * @param dY The y-coordinate to set.
     */
    @Override
    public  void setOriginPointY(double dY)
    {
        setY(dY - getOriginY());
    }
    
    /**
     * Sets the position of the object while taking the origin to account.
     * @param dX The x-coordinate to set.
     * @param dY The y-coordinate to set.
     */
    @Override
    public void setPosition(double dX, double dY)
    {
        setOriginPointX(dX);
        setOriginPointY(dY);
    }
    
    /**
     * Performs a horizontal translation by the specified value.
     * @param dDistance The distance to horizontally shift the object by.
     */
    @Override
    public void moveX(double dDistance)
    {
        setX(getX() + dDistance);
    }
    
    /**
     * Performs a vertical translation by the specified value.
     * @param dDistance The distance to vertically shift the object by.
     */
    @Override
    public void moveY(double dDistance)
    {
        setY(getY() + dDistance);
    }
    
    /**
     * Performs both a horizontal and vertical shift by the specified values.
     * @param dDistanceX The distance to horizontally shift the object by.
     * @param dDistanceY The distance to vertically shift the object by.
     */
    @Override
    public void move(double dDistanceX, double dDistanceY)
    {
        moveX(dDistanceX);
        moveY(dDistanceY);
    }
    
    /**
     * Returns the x-coordinate of the left side of this object's bounding box (useful for collision testing).
     * @return The x-coordinate of the left side of this object's bounding box.
     */
    @Override
    public double getLeft()
    {
        return getX();
    }
    
    /**
     * Returns the x-coordinate of the right side of this object's bounding box (useful for collision testing).
     * @return The x-coordinate of the right side of this object's bounding box.
     */
    @Override
    public double getRight()
    {
        return getLeft() + getFitWidth();
    }
    
    /**
     * Returns the y-coordinate of the top of this object's bounding box (useful for collision testing).
     * @return The y-coordinate of the top of this object's bounding box.
     */
    @Override
    public double getTop()
    {
        return getY();
    }
    
    /**
     * Returns the y-coordinate of the bottom of this object's bounding box (useful for collision testing).
     * @return The y-coordinate of the bottom of this object's bounding box.
     */
    @Override
    public double getBottom()
    {
        return getTop() + getFitHeight();
    }
    
    /**
     * Checks whether this object's bounding box is overlapping another's (simple collision testing).
     * @param other The other object to test the collision with.
     * @return True if their bounding boxes overlap, false otherwise.
     */
    @Override
    public boolean isCollision(Collidable other)
    {
        if(getBottom() < other.getTop()
                || getTop() > other.getBottom()
                || getLeft() > other.getRight()
                || getRight() < other.getLeft())
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * Rotates the object by a specified angle.
     * @param dAngle The angle to rotate the object by.
     */
    @Override
    public void rotate(double dAngle)
    {
       getTransforms().add(new Rotate(dAngle, getX() + getOriginX(), getY() + getOriginY()));
    }
    
    /**
     * Flips the image horizontally.
     */
    public void flipHor()
    {
        setScaleX(-getScaleX());
    }
    
    /**
     * Flips the image vertically.
     */
    public void flipVert()
    {
        setScaleY(-getScaleY());
    }
    
    /**
     * Checks whether the specified image is this object's current image.
     * @param spriteImage The image to compare to.
     * @return True if the specified image is this object's current image, false otherwise.
     */
    public boolean isCurrentImage(Image spriteImage)
    {
        return getImage() == spriteImage;
    }
    
    /**
     * This method should be called in an AnimationTimer object. This method should be overridden, and all 
     * of the functions that are called every frame should be written in this method.
     */
    public abstract void update();
}
