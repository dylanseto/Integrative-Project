

package javafxgame2D.mainGameElements;

import java.util.HashMap;
import javafx.event.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.*;

/**
 *
 * @author Ahmad El-Baher
 */
public class GameScene extends Scene 
{
    private final static HashMap<KeyCode, EventType<KeyEvent>> keyboardMap = new HashMap<>();
    private static EventType<MouseEvent> mouseEvent;
    private static MouseButton mouseButtonUsed = MouseButton.NONE;
    
    public GameScene(Parent root, double width, double height) 
    {
        super(root, width, height);
        setOnKeyPressed(new KeyPressedHandler());
        setOnKeyReleased(new KeyReleasedHandler());
        setOnMouseClicked(new MouseClickedHandler());
    }
    
    static
    {
        for(KeyCode keyCode : KeyCode.values())
        {
            keyboardMap.put(keyCode, KeyEvent.ANY);
        }
    }
    
    public static boolean isKeyPressed(KeyCode codeKeyPressed)
    {
        return keyboardMap.get(codeKeyPressed) == KeyEvent.KEY_PRESSED;
    }
    
    public static boolean isKeyReleased(KeyCode codeKeyReleased)
    {
        return keyboardMap.get(codeKeyReleased) == KeyEvent.KEY_RELEASED;
    }
    
    public static boolean isMouseClicked(MouseButton mouseButton)
    {
        return mouseEvent == MouseEvent.MOUSE_CLICKED && mouseButtonUsed == mouseButton;
    }
    
    private class KeyPressedHandler implements EventHandler<KeyEvent>
    {
        
        @Override
        public void handle(KeyEvent event) 
        {
            keyboardMap.replace(event.getCode(), event.getEventType());
        }
    }
    
    private class KeyReleasedHandler implements EventHandler<KeyEvent>
    {

        @Override
        public void handle(KeyEvent event) 
        {
            keyboardMap.replace(event.getCode(), event.getEventType());
        }
    }
    
    private class MouseClickedHandler implements EventHandler<MouseEvent>
    {

        @Override
        public void handle(MouseEvent event) 
        {
            mouseEvent = (EventType<MouseEvent>) event.getEventType();
            mouseButtonUsed = event.getButton();
        }
    }
    
    public static void resetEvents()
    {
        mouseEvent = MouseEvent.ANY;
        for(KeyCode keyCode : KeyCode.values())
        {
            if(keyboardMap.get(keyCode) == KeyEvent.KEY_RELEASED)
            {
                keyboardMap.replace(keyCode, KeyEvent.ANY);
            }
        }
    }
}