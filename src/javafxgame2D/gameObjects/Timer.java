

package javafxgame2D.gameObjects;

/**
 * This class represents a timer that increments after every frame of the game. Useful for animations, shooting, and
 * other elements that require a short delay.
 * @author Ahmad El-Baher
 */
public class Timer 
{
    private int m_nMaxTime;
    private int m_nCurrentTime;
    private boolean m_bTimerRunning;

    /**
     * Default constructor.
     * Constructs the timer with its max time being 1 frame, sets the "running" flag to false.
     */
    public Timer()
    {
        this(1, false);
    }
    
    /**
     * Constructs the timer with the specified max time (the number of frames it will delay before restarting) and
     * the specified value for the "running" flag.
     * @param nMaxTime The number of frames this timer will delay before restarting.
     * @param bTimerRunning The flag signaling whether this timer should begin running or not.
     */
    public Timer(int nMaxTime, boolean bTimerRunning)
    {
        m_nMaxTime = nMaxTime;
        m_nCurrentTime = 0;
        m_bTimerRunning = bTimerRunning;
    }
    
    /**
     * Firstly, it checks whether the timer is running or not, and if not, it returns false and resets the timer.
     * Otherwise, it moves on to check whether the delay has been completed or not. If so, it resets the timer
     * and returns true. Otherwise, it increments the timer by one frame and returns false.
     * @return True if the delay has been completed, false otherwise or if the timer is not running.
     */
    public boolean isTimeUp()
    {
        if(!isTimerRunning())
        {
            if(m_nCurrentTime > 0)
            {
                m_nCurrentTime = 0;
            }
            return false;
        }
        
        if(m_nCurrentTime >= m_nMaxTime)
        {
            m_nCurrentTime = 0;
            return true;
        }
        else
        {
            m_nCurrentTime++;
            return false;
        }
    }
    
    /**
     * Sets the number of frames this timer delays.
     * @param nMaxTime The number of frames this timer delays.
     */
    public void setMaxTime(int nMaxTime)
    {
        m_nMaxTime = nMaxTime;
    }
    
    /**
     * Gets the number of frames this timer delays.
     * @return The number of frames this timer delays.
     */
    public int getMaxTime()
    {
        return m_nMaxTime;
    }
    
    /**
     * Checks whether this timer is running or not.
     * @return True if the timer is running, false otherwise.
     */
    public boolean isTimerRunning()
    {
        return m_bTimerRunning;
    }
    
    /**
     * Sets the flag signaling whether or not the timer is running.
     * @param bTimerRunning The flag signaling whether or not the timer is running.
     */
    public void setTimerRunning(boolean bTimerRunning)
    {
        m_bTimerRunning = bTimerRunning;
    }
}
