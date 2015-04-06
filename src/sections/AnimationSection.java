package sections;

import java.util.concurrent.TimeUnit;
import java.lang.Math;

import Main.Constants;
import Main.MainWindow;
import calculations.FormulaHelper;
import calculations.Variables;
import java.util.Arrays;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import sections.animationObjects.CartClass;

public class AnimationSection extends Canvas
{
	private CartClass newtonLawCart;
	private long elapsedTime = System.nanoTime();
	private long initTime = System.nanoTime();
	private long previousTime = initTime;
	private double prevDistance;
        
        //for thin film
        private int clearRectLengthReduction = Constants.ZERO;
        private int pi_zeroAlphaIncrease = Constants.ZERO;
	
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
            
            getGraphicsContext2D().fillRect(Constants.ZERO, Constants.TOP_OF_MATERIAL_Y_POS, Constants.END_POINT_X_POS, Constants.MATERIAL_HEIGHT);//draws material
            
            getGraphicsContext2D().setFill(Color.BLACK);//drawing film
            
            double filmHeight = Variables.getThickness()/Constants.MAX_FILM_HEIGHT;
            
            if(filmHeight > Constants.ZERO && filmHeight < Constants.MIN_FILM_HEIGHT)
            {
                filmHeight = Constants.MIN_FILM_HEIGHT;
            }
            else if(filmHeight > Constants.MAX_FILM_HEIGHT)
            {
                filmHeight = Constants.MAX_FILM_HEIGHT;
            }
            
            double topOfFilm = Constants.TOP_OF_MATERIAL_Y_POS - filmHeight;
            getGraphicsContext2D().fillRect(Constants.ZERO, topOfFilm, Constants.END_POINT_X_POS, filmHeight);
            
            if(drawLines)
            {
                MainWindow.getTableSection().clearRows();

                getGraphicsContext2D().setStroke(Color.RED);
                getGraphicsContext2D().strokeLine(Constants.ZERO, Constants.ZERO, Constants.MIDDLE_OF_FILM_X_POS, topOfFilm);//line hitting film
                getGraphicsContext2D().strokeLine(Constants.MIDDLE_OF_FILM_X_POS, topOfFilm, Constants.END_POINT_X_POS, Constants.ZERO);//line rebounding off film
                
                double theta = Math.atan2(topOfFilm, Constants.MIDDLE_OF_FILM_X_POS);
                getGraphicsContext2D().strokeLine(Constants.MIDDLE_OF_FILM_X_POS, topOfFilm, Constants.MIDDLE_OF_FILM_X_POS + filmHeight * Math.tan(Constants.ONE_HALF * Math.PI - theta), Constants.TOP_OF_MATERIAL_Y_POS);//line hitting material
                double yPosSecondRay = filmHeight*(Constants.ONE + Math.tan(Constants.ONE_HALF * Math.PI - theta) * Math.tan(theta));
                getGraphicsContext2D().strokeLine(Constants.MIDDLE_OF_FILM_X_POS + filmHeight * Math.tan(Constants.ONE_HALF * Math.PI - theta), Constants.TOP_OF_MATERIAL_Y_POS, Constants.END_POINT_X_POS, yPosSecondRay);//line rebounding off material
                
                if(clearRectLengthReduction < (int)Constants.END_POINT_X_POS)
                {
                    getGraphicsContext2D().clearRect(clearRectLengthReduction, Constants.ZERO, Constants.END_POINT_X_POS - clearRectLengthReduction, topOfFilm);
                    getGraphicsContext2D().setFill(Color.BLACK);
                    getGraphicsContext2D().fillRect(clearRectLengthReduction, topOfFilm, Constants.END_POINT_X_POS - clearRectLengthReduction, Constants.TOP_OF_MATERIAL_Y_POS - topOfFilm);
                    ++clearRectLengthReduction;
                }
                else if(clearRectLengthReduction >= (int)Constants.END_POINT_X_POS)
                {
                    double yPosSymbol_2 = yPosSecondRay + Constants.Y_POS_SHIFT_SYMBOL_2;
                    
                    getGraphicsContext2D().setFill(Color.rgb(Constants.ZERO, Constants.ZERO, Constants.ZERO, (double)(pi_zeroAlphaIncrease)/Constants.MAX_PI_ZERO_ALPHA));
                    if(Variables.getIndexRefFilm() > Constants.INDEX_REF_AIR)
                    {
                        getGraphicsContext2D().fillText(Constants.PI_TEXT, Constants.X_POS_SYMBOL_1, Constants.Y_POS_SYMBOL_1);
                    }
                    else
                    {
                        getGraphicsContext2D().fillText(String.valueOf(Constants.ZERO), Constants.X_POS_SYMBOL_1, Constants.Y_POS_SYMBOL_1);
                    }

                    if(Variables.getIndexRefMaterial() > Variables.getIndexRefFilm())
                    {
                        getGraphicsContext2D().fillText(Constants.PI_TEXT, Constants.X_POS_SYMBOL_2, yPosSymbol_2);
                    }
                    else
                    {
                        getGraphicsContext2D().fillText(String.valueOf(Constants.ZERO), Constants.X_POS_SYMBOL_2, yPosSymbol_2);
                    }
                    
                    
                    if(pi_zeroAlphaIncrease < Constants.MAX_PI_ZERO_ALPHA)
                    {
                        ++pi_zeroAlphaIncrease;
                    }
                    else if(pi_zeroAlphaIncrease >= Constants.MAX_PI_ZERO_ALPHA)
                    {
                        Variables.setWaveLengthsDest(FormulaHelper.getWaveLengthsDestructive(Variables.getIndexRefFilm(), Variables.getThickness()));
                        Variables.setWaveLengthsConst(FormulaHelper.getWaveLengthsConstructive(Variables.getIndexRefFilm(), Variables.getThickness()));

                        if(Variables.getWaveLengthsDest().size() == Variables.getWaveLengthsConst().size())
                        {
                            for(int i = Constants.ZERO; i < Variables.getWaveLengthsConst().size(); ++i)
                            {
                                MainWindow.getTableSection().addRow(Variables.getWaveLengthsDest().get(i), Variables.getWaveLengthsConst().get(i));
                            }
                        }
                        if(Variables.getWaveLengthsDest().size() > Variables.getWaveLengthsConst().size())
                        {   
                            int lastIndexConst = Constants.ZERO;
                            for(int i = Constants.ZERO; i < Variables.getWaveLengthsConst().size(); ++i)
                            {
                                MainWindow.getTableSection().addRow(Variables.getWaveLengthsDest().get(i), Variables.getWaveLengthsConst().get(i));
                                if(i == Variables.getWaveLengthsConst().size() - Constants.ONE)
                                {
                                    lastIndexConst = i + Constants.ONE;
                                }
                            }
                            for(int i = lastIndexConst; i < Variables.getWaveLengthsDest().size(); ++i)
                            {
                                MainWindow.getTableSection().addLeftValue(String.valueOf(Variables.getWaveLengthsDest().get(i)));
                            }
                        }
                        else if(Variables.getWaveLengthsDest().size() < Variables.getWaveLengthsConst().size())
                        {
                            int lastIndexDest = Constants.ZERO;
                            for(int i = Constants.ZERO; i < Variables.getWaveLengthsDest().size(); ++i)
                            {
                                MainWindow.getTableSection().addRow(Variables.getWaveLengthsDest().get(i), Variables.getWaveLengthsConst().get(i));

                                if(i == Variables.getWaveLengthsDest().size() - Constants.ONE)
                                {
                                    lastIndexDest = i + Constants.ONE;
                                }
                            }
                            for(int i = lastIndexDest; i < Variables.getWaveLengthsConst().size(); ++i)
                            {
                                MainWindow.getTableSection().addRow(Constants.EMPTY_STRING, String.valueOf(Variables.getWaveLengthsConst().get(i)));
                            }
                        }

                        clearRectLengthReduction = Constants.ZERO;
                        pi_zeroAlphaIncrease = Constants.ZERO;
                        MainWindow.getGUIControlSection().setDisable(false);
                        stop();
                    }
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