package sections.animationObjects;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class CircleClass extends AnimationObject 
{
	private Color color;
	private double angle;
	private Random rand; 
	private boolean negative;
	
	public CircleClass(GraphicsContext graphics) 
	{
		super(graphics);
		
		this.rand = new Random();
		this.color = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
		this.angle = rand.nextInt(180); //change to constants ------------------------------
		this.negative = rand.nextBoolean();
		this.setX(rand.nextInt(300));
		this.setY(rand.nextInt(300));
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public boolean isNegative() {
		return negative;
	}

	public void setNegative(boolean negative) {
		this.negative = negative;
	}

	@Override
	public void draw() {
		Paint temp = this.graphics.getFill();
		this.graphics.setFill(this.color);
		this.graphics.fillOval(x_property.get(), y_property.get(), 10, 10);
		this.graphics.setFill(temp);
		
	}

}
