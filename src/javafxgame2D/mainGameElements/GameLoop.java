

package javafxgame2D.mainGameElements;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;

/**
 *
 * @author Ahmad El-Baher
 */
public abstract class GameLoop extends AnimationTimer
{
    private final GameObjectManager gameObjectManager;
    
    public GameLoop()
    {
        gameObjectManager = new GameObjectManager();
    }
    
    public GameObjectManager getGameObjectManager()
    {
        return gameObjectManager;
    }
    
    public void addAllObjectsToGroup(Group group)
    {
        for(int i = 0; i < gameObjectManager.size(); ++i)
        {
            if(!group.getChildren().contains(gameObjectManager.getObject(i)))
            {
                group.getChildren().add(gameObjectManager.getObject(i));
            }
        }
    }
}
