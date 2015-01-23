

package javafxgame2D.mainGameElements;

import javafxgame2D.gameObjects.VisibleGameObject;
import java.util.LinkedList;

/**
 *
 * @author Ahmad El-Baher
 */
public class GameObjectManager 
{
    private final LinkedList<VisibleGameObject> gameObjectList;
    private static boolean bAllPaused;
    
    public GameObjectManager()
    {
        gameObjectList = new LinkedList<>();
    }
    
    public void addObject(VisibleGameObject gameObject)
    {
        gameObjectList.add(gameObject);
    }
    
    public void removeObject(int nIndex)
    {
        gameObjectList.remove(nIndex);
    }
    
    public void removeObject(VisibleGameObject gameObject)
    {
        gameObjectList.remove(gameObject);
    }
    
    public void clear()
    {
        gameObjectList.clear();
    }
    
    public boolean contains(VisibleGameObject gameObject)
    {
        return gameObjectList.contains(gameObject);
    }
    
    public VisibleGameObject getObject(int nIndex)
    {
        return gameObjectList.get(nIndex);
    }
    
    public int size()
    {
        return gameObjectList.size();
    }
    
    public void updateAll()
    {
        if(!isAllPaused())
        {
            for(VisibleGameObject gameObject : gameObjectList)
            {
                gameObject.update();
            }
        }
    }
    
    public static void setAllPaused(boolean bPauseAll)
    {
        bAllPaused = bPauseAll;
    }
    
    public static boolean isAllPaused()
    {
        return bAllPaused;
    }
}
