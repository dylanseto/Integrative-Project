


package javafxgame2D.gameObjects;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * A custom class that extends Canvas and can be used to make custom canvas classes, such as the Sudoku grid.
 * @author Ahmad El-Baher
 */
public abstract class JavaFXCanvas extends Canvas
{
    private GraphicsContext m_graphics;
    
    /**
     * Default constructor.
     * Constructs the canvas and initializes the canvas's width and height to one (1).
     */
    protected JavaFXCanvas()
    {
        this(1, 1);
    }
    
    /**
     * Constructs the canvas with user-defined width and height values.
     * @param dCanvasWidth  The width of the canvas to set.
     * @param dCanvasHeight  The height of the canvas to set.
     */
    protected JavaFXCanvas(double dCanvasWidth, double dCanvasHeight)
    {
        super(dCanvasWidth, dCanvasHeight);
        m_graphics = getGraphicsContext2D();
    }
    
    /**
     * Returns the graphics.
     * @return the graphics.
     */
    protected final GraphicsContext getGraphics()
    {
        return m_graphics;
    }
    
    /**
     * Draws the required shapes. Will be implemented by the subclasses.
     */
    protected abstract void draw();
}
