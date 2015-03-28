package sections;

import java.util.concurrent.TimeUnit;
import java.lang.Math;

import Main.Constants;
import Main.MainWindow;
import calculations.FormulaHelper;
import calculations.Variables;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import sections.animationObjects.CartClass;

public class AnimationSection extends Canvas
{
	CartClass newtonLawCart;
	long elapsedTime = System.nanoTime();
	long initTime = System.nanoTime();
	long previousTime = initTime;
	double prevDistance;
	
	AnimationTimer animTimer = new AnimationTimer(){
		@Override
		public void handle(long time) 
		{
                    
			switch(MainWindow.getUserInterface())
			{
				case NO_CHOICE: 
                                    break;
                                    
				case NEWTON_LAW:
									GUIControlSection gcs = MainWindow.getGUIControlSection();
									Variables.setAcceleration(FormulaHelper.computeAccel(Variables.getForce(), Variables.getMass()));
									long totalTime = time - initTime;
									
									Variables.setVelocity(FormulaHelper.computeVelocity(((double)(totalTime))/1000000000, Variables.getAcceleration()));
		
									elapsedTime = time-previousTime;
									previousTime = time;
									
									Variables.setDisplacement(FormulaHelper.computeDisplacement(((double)(elapsedTime))/1000000000, Variables.getVelocity(), Variables.getDisplacement()));
									//prevDistance = distance;
									newtonLawCart.setX(Variables.getDisplacement());
				
							
									if(totalTime % 100 == 1)
									{
										MainWindow.getChartSection().addDataPoint(((double)(totalTime))/1000000000, Variables.getVelocity(), true);
									}
									/*if(Math.floor((double)(totalTime/1000000000)) == ((double)(totalTime/1000000000)))
									{*/
									//MainWindow.getChartSection().addDataPoint(totalTime, Variables.getVelocity()*1000);
									//}
						
									drawNewtonFrame();
                                    break;
                                    
				case PROJ_MOTION:
                                    drawProjMotFrame();
                                    break;
                                    
				case OPTICS:
                                    drawOpticsFrame();
                                    break;
                                    
				case THIN_FILM:
                                    drawThinFilmFrame(true);
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
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
            newtonLawCart.drawCart();
	}
        
	private void drawProjMotFrame()
	{
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
	}
        
	private void drawOpticsFrame()
	{
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
	}
        
	private void drawThinFilmFrame(boolean drawLines)
	{
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
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
            
            getGraphicsContext2D().setFill(Color.BLACK);
            getGraphicsContext2D().fillRect(0, 225 - Variables.getThickness(), 300, Variables.getThickness());
            
            //so far it's drawing the lines automatically done; next step is to make it so that the user can actually watch the lines being drawn.
            if(drawLines)
            {
                double topOfMaterial = 225, 
                       topOfFilm = topOfMaterial - Variables.getThickness(), 
                       middleOfFilm = 150,
                       endPoint = 300;
    
                getGraphicsContext2D().setStroke(Color.RED);
                getGraphicsContext2D().strokeLine(0, 0, middleOfFilm, topOfFilm);//line hitting film
                getGraphicsContext2D().strokeLine(middleOfFilm, topOfFilm, endPoint, 0);//line rebounding off film
                
                double theta = Math.atan2(topOfFilm, middleOfFilm);
                getGraphicsContext2D().strokeLine(middleOfFilm, topOfFilm, middleOfFilm + Variables.getThickness() * Math.tan(Math.PI/2 - theta), topOfMaterial);//line hitting material
                double yPosSecondRay = Variables.getThickness()*( 1 + Math.tan(Math.PI/2 - theta) * Math.tan(theta));
                getGraphicsContext2D().strokeLine(middleOfFilm + Variables.getThickness() * Math.tan(Math.PI/2 - theta), topOfMaterial, endPoint, yPosSecondRay);//line rebounding off material
                
                //FIX THIS!!!!
                double xPosSymbol = endPoint - 10,
                       yPosSymbol_1 = 30,
                       yPosSymbol_2 = yPosSecondRay + yPosSymbol_1;
                
                getGraphicsContext2D().setFill(Color.BLACK);
                if(Variables.getIndexRefFilm() > Constants.INDEX_REF_AIR)
                {
                    getGraphicsContext2D().fillText("pi", xPosSymbol, yPosSymbol_1);
                }
                else
                {
                    getGraphicsContext2D().fillText(String.valueOf(Constants.ZERO), xPosSymbol, yPosSymbol_1);
                }
                
                if(yPosSecondRay > topOfFilm)
                {
                    getGraphicsContext2D().setFill(Color.WHITE);
                }
                
                if(Variables.getIndexRefMaterial() > Variables.getIndexRefFilm())
                {
                    getGraphicsContext2D().fillText("pi", xPosSymbol, yPosSymbol_2);
                }
                else
                {
                    getGraphicsContext2D().fillText(String.valueOf(Constants.ZERO), xPosSymbol, yPosSymbol_2);
                }

            }
            
	}
        
        public void drawThinFlimFrame()
        {
            drawThinFilmFrame(false);
        }
        
	private void drawNewBikeFrame()
	{
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
	}
        
	private void drawInfSeriesFrame()
	{
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
	}
        
	public void start()
	{
		MainWindow.getChartSection().addDataPoint(0, 0);
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