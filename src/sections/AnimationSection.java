package sections;

import Main.Constants;
import Main.MainWindow;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import sections.animationObjects.CartClass;

public class AnimationSection extends Canvas
{
	CartClass newtonLawCart;
	AnimationTimer animTimer = new AnimationTimer(){
		@Override
		public void handle(long arg0) 
		{
                    getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
			switch(MainWindow.getUserInterface())
			{
				case NO_CHOICE: break;
				case NEWTON_LAW: break;
				case PROJ_MOTION:
                                    drawProjMotFrame();
                                    break;
				case OPTICS: break;
				case THIN_FILM: break;
				case SPORTS_BIKE: break;
				case INF_GEOM_SERIES: break;
				default: break; //ERROR
			}
		}
	};
	
	public AnimationSection()
	{
		newtonLawCart = new CartClass(this.getGraphicsContext2D()); //work on this.
	}
	public void drawNewtonFrame()
	{
		newtonLawCart.drawCart();
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
		this.animTimer.start();
	}
	public void stop()
	{
		this.animTimer.stop();
	}
	public void reset()
	{
		this.newtonLawCart.setX(0);
	}
}