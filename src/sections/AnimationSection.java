package sections;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import sections.animationObjects.CartClass;

public class AnimationSection extends Canvas
{
	CartClass newtonLawCart;
	AnimationTimer animTimer = new AnimationTimer(){
		@Override
		public void handle(long arg0) 
		{
		}
	};;
	
	public AnimationSection()
	{
		newtonLawCart = new CartClass(this.getGraphicsContext2D()); //work on this.
	}
	private void drawNewtonFrame()
	{
		
	}
	private void drawProjMotFrame()
	{
		
	}
	private void drawOpticsFrame()
	{
		
	}
	private void drawThinFilmFrame()
	{
		
	}
	private void drawNewBikeFrame()
	{
		
	}
	private void drawInfSeriesFrame()
	{
		
	}
	public void start()
	{
		
	}
	public void stop()
	{
		
	}
	public void reset()
	{
		
	}
}