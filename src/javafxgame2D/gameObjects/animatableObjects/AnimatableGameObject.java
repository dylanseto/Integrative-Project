
package javafxgame2D.gameObjects.animatableObjects;

import javafxgame2D.gameObjects.Timer;
import javafxgame2D.gameObjects.VisibleGameObject;

/**
 * A visible game object with an animating sprite. Contains useful functions for playing and pausing the animation.
 * @author Ahmad El-Baher
 */
public class AnimatableGameObject extends VisibleGameObject
{
    private final Timer m_animTimer;
    private int m_nFrame;
    private AnimatableImage m_spriteImage;
    
    /**
     * Constructs the animatable object with the specified image and the animation speed set to one frame delay between frames,
     * and the origin to the top left corner.
     * @param spriteImage The animatable image to set.
     */
    public AnimatableGameObject(AnimatableImage spriteImage)
    {
        this(spriteImage, 1, 0.0, 0.0);
    }
    
    /**
     * Constructs the animatable object with the specified image and animation speed, and sets the origin to the top left corner.
     * @param spriteImage The animatable image to set.
     * @param nAnimSpeed The animation speed (duration of delay between frames expressed in integer number of frames).
     */
    public AnimatableGameObject(AnimatableImage spriteImage, int nAnimSpeed)
    {
        this(spriteImage, nAnimSpeed, 0.0, 0.0);
    }
    
    /**
     * Constructs this animatable object with the specified animatable image, animation speed, and origin coordinates.
     * @param spriteImage The animatable image to set.
     * @param nAnimSpeed The animation speed (duration of delay between frames expressed in integer number of frames).
     * @param dOriginX The x-coordinate of the origin of this object.
     * @param dOriginY The y-coordinate of the origin of this object.
     */
    public AnimatableGameObject(AnimatableImage spriteImage, int nAnimSpeed, double dOriginX, double dOriginY) 
    {
        super(spriteImage, dOriginX, dOriginY);
        m_spriteImage = spriteImage;
        m_animTimer = new Timer(nAnimSpeed, true);
        m_nFrame = 0;
        setViewport(m_nFrame);
        setSize(m_spriteImage.getFrameWidth(), m_spriteImage.getFrameHeight());
    }
    
    /**
     * Sets the object's animatable image.
     * @param spriteImage The animatable image to set.
     */
    public void setImage(AnimatableImage spriteImage)
    {
        setVisible(false);
        super.setImage(spriteImage);
        setSize(spriteImage.getFrameWidth(), spriteImage.getFrameHeight());
        setVisible(true);
        m_spriteImage = spriteImage;
        
    }
    
    /**
     * Gets the animation speed (delay between frames expressed in integer number of frames).
     * @return The animation speed.
     */
    public double getAnimSpeed()
    {
        return m_animTimer.getMaxTime();
    }
    
    /**
     * Sets the animation speed (delay between frames expressed in integer number of frames).
     * @param nAnimSpeed The animation speed (delay between frames expressed in integer number of frames).
     */
    public void setAnimSpeed(int nAnimSpeed)
    {
        m_animTimer.setMaxTime(nAnimSpeed);
    }
    
    /**
     * Sets the frame width of the object.
     * @param dWidth The frame width of the object.
     */
    @Override
    public void setWidth(double dWidth)
    {
        super.setWidth(dWidth);
        m_spriteImage.setFrameWidth(dWidth);
    }
    
    /**
     * 
     * @param dHeight 
     */
    @Override
    public void setHeight(double dHeight)
    {
        super.setHeight(dHeight);
        m_spriteImage.setFrameHeight(dHeight);
    }

    protected void setViewport(int nFrameX)
    {
        super.setViewport(m_spriteImage.getViewportRect(nFrameX));
    }
    
    protected void changeFrame()
    {
        if(m_nFrame >= m_spriteImage.getNumFrames())
        {
            m_nFrame = 0;
        }
        
        setViewport(m_nFrame++);
    }
    
    protected void animate()
    {
        if(m_animTimer.isTimeUp())
        {
            changeFrame();
        } 
    }
    
    public void pauseAnimation()
    {
        m_animTimer.setTimerRunning(false);
    }
    
    public void playAnimation()
    {
        m_animTimer.setTimerRunning(true);
    }
    
    public void setFrame(int nFrame)
    {
        if(nFrame >= 0 && nFrame <= getLastFrame())
        {
            m_nFrame = nFrame;
            setViewport(m_nFrame);
        }
    }
    
    public int getLastFrame()
    {
        return m_spriteImage.getLastFrame();
    }

    @Override
    public void update() 
    {
        animate();
    }
}
