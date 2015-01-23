

package javafxgame2D.gameObjects.animatableObjects;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author Ahmad El-Baher
 */
public class AnimatableImage extends Image
{
    private double m_dFrameWidth;
    private double m_dFrameHeight;
    private final int NUM_FRAMES;
    
    public AnimatableImage(String strUrl, int nNumFrame) 
    {
        super(strUrl);
        NUM_FRAMES = nNumFrame;
        m_dFrameWidth = super.getWidth()/NUM_FRAMES;
        m_dFrameHeight = super.getHeight();
    }
    
    public AnimatableImage(String strUrl, double dFrameWidth, double dFrameHeight) 
    {
        super(strUrl);
        m_dFrameWidth = dFrameWidth;
        m_dFrameHeight = dFrameHeight;
        NUM_FRAMES = (int)(super.getWidth()/m_dFrameWidth);
    }
    
    public Rectangle2D getViewportRect(int nFrame)
    {
        return new Rectangle2D(nFrame * m_dFrameWidth, 0.0, m_dFrameWidth, m_dFrameHeight);
    }
    
    public double getFrameWidth()
    {
        return m_dFrameWidth;
    }
    
    public void setFrameWidth(double dFrameWidth)
    {
        m_dFrameWidth = dFrameWidth;
    }
    
    public double getFrameHeight()
    {
        return m_dFrameHeight;
    }
    
    public void setFrameHeight(double dFrameHeight)
    {
        m_dFrameHeight = dFrameHeight;
    }
    
    public void setFrameSize(double dFrameWidth, double dFrameHeight)
    {
        setFrameWidth(dFrameWidth);
        setFrameHeight(dFrameHeight);
    }
    
    public int getNumFrames()
    {
        return NUM_FRAMES;
    }
    
    public int getLastFrame()
    {
        return getNumFrames() - 1;
    }
}
