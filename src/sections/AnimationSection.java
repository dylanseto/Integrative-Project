package sections;

import Main.Constants;
import Main.MainWindow;
import calculations.Variables;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
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
				case NO_CHOICE: 
                                    break;
                                    
				case NEWTON_LAW:
                                    drawNewtonFrame();
                                    break;
                                    
				case PROJ_MOTION:
                                    drawProjMotFrame();
                                    break;
                                    
				case OPTICS:
                                    drawOpticsFrame();
                                    break;
                                    
				case THIN_FILM:
                                    drawThinFilmFrame();
                                    break;
                                    
				case SPORTS_BIKE:
                                    drawNewBikeFrame();
                                    break;
                                    
				case INF_GEOM_SERIES: 
                                    drawInfSeriesFrame();
                                    break;
                                    
				default: 
                                    break; //ERROR
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
            
            if(Variables.getMaterialType().equalsIgnoreCase("water"))
            {
                getGraphicsContext2D().setFill(Color.BLUE);
            }
            else if(Variables.getMaterialType().equalsIgnoreCase("glycerin"))
            {
                getGraphicsContext2D().setFill(Color.GREY);//make different shade of grey
            }
            else if(Variables.getMaterialType().equalsIgnoreCase("oil"))
            {
                getGraphicsContext2D().setFill(Color.GREY);//make different shade of grey
            }
            else if(Variables.getMaterialType().equalsIgnoreCase("zircon"))
            {
                getGraphicsContext2D().setFill(Color.LIGHTBLUE);//make bright blue
            }
            else if(Variables.getMaterialType().equalsIgnoreCase("diamond"))
            {
                getGraphicsContext2D().setFill(Color.LIGHTGRAY);//make bright shade of grey
            }
            else if(Variables.getMaterialType().equalsIgnoreCase("pyrex"))
            {
                getGraphicsContext2D().setFill(Color.LIGHTGRAY);//make an opaque grey
            }
            
            getGraphicsContext2D().fillRect(0, 225, 300, 75);
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