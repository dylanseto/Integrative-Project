package sections.animationObjects;

import java.util.Random;

import Main.Constants;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class CartClass
{	
	
	private DoubleProperty x_property;
	private DoubleProperty y_property;
	private Timeline timeline;
	private boolean isRunning;
	
	private GraphicsContext graphics;
	
	public CartClass(GraphicsContext graphics) 
	{
		this.x_property = new SimpleDoubleProperty();
		this.y_property = new SimpleDoubleProperty();
		
		this.graphics = graphics;
		this.isRunning = false;
		
		/*timeline = new Timeline(
	            new KeyFrame(Duration.seconds(Constants.ZERO),
	                    new KeyValue(x_property, Constants.ZERO),
	                    new KeyValue(y_property, Constants.ZERO)
	            ),
	            new KeyFrame(Duration.seconds(rand.nextInt(Constants.MAX_SPEED)+Constants.MAX_SPEED),
	            		new KeyValue(x_property, Constants.ANIMATION_POINT),
	                    new KeyValue(y_property, Constants.ZERO)
	            )
	        );*/
		
		//timeline.setAutoReverse(true);
                //timeline.setCycleCount(Timeline.INDEFINITE);
	}
	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}
	public void startCart()
	{
		this.isRunning = true;
		timeline.play();
	}
	public void stopCart()
	{
		this.isRunning = false;
		timeline.stop();
	}
	public boolean isRunning() {
		return isRunning;
	}
	public void drawCart()
	{
		graphics.setFill(Color.BLACK);
		graphics.strokeLine(0, 40, 300, 40);
		
		graphics.setFill(Color.BLUE);
		double[] x = Constants.Car_Polygon_X.clone();
		double[] y = Constants.Car_Polygon_Y.clone();
		
		for(int i = Constants.ZERO; i < Constants.POLYGON_SIDE_NUM; i ++)
		{
			y[i] += (y_property.doubleValue());
			x[i] += x_property.doubleValue();
		}
		
		graphics.fillPolygon(x, y, Constants.POLYGON_SIDE_NUM);
		graphics.setFill(Color.BLACK);
		graphics.fillOval(x_property.doubleValue()+Constants.CAR_WHEEL_ONE_INIT_X, y_property.doubleValue()+Constants.CAR_WHEEL_INIT_Y, Constants.CAR_WHEEL_DIAMETER, Constants.CAR_WHEEL_DIAMETER);
		graphics.fillOval(x_property.doubleValue()+Constants.CAR_WHEEL_TWO_INIT_X, y_property.doubleValue()+Constants.CAR_WHEEL_INIT_Y, Constants.CAR_WHEEL_DIAMETER, Constants.CAR_WHEEL_DIAMETER);
	}
	public DoubleProperty getX() {
		return x_property;
	}
	public void setX(double x)
	{
		x_property.set(x);
	}
	public DoubleProperty getY() {
		return y_property;
	}
	public void setY(double y)
	{
		y_property.set(y);
	}
}
