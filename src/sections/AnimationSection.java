package sections;


import java.util.concurrent.TimeUnit;

import Main.Constants;
import Main.MainWindow;
import calculations.FormulaHelper;
import calculations.Variables;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.util.Duration;
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
        private Color materialColor = null;
        
        //for new bike
        private double priceX_Intercept_1 = Constants.ZERO,
                       priceX_Intercept_2 = Constants.ZERO;
        private int deltaX_AddPoint = 0;
	
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

			        newtonLawCart.addKeyFrame(new KeyFrame(new Duration(TimeUnit.NANOSECONDS.toMillis(totalTime)), new KeyValue(newtonLawCart.getX(), Variables.getDisplacement()*40)));
			        //System.out.println(newtonLawCart.getTimeline().getKeyFrames().size());
			        newtonLawCart.getTimeline().play();



			        MainWindow.getChartSection().addDataPoint(((double)(totalTime))/1000000000, Variables.getVelocity(), true);
                                    drawNewtonFrame(time);
                                    break;
                                    
				case PROJ_MOTION:
                                    drawProjMotFrame();
                                    break;
                                    
				case OPTICS:
                                    drawOpticsFrame(true);
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
	public void drawNewtonFrame(long time)
	{		
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
            newtonLawCart.drawCart();
	}
        
	private void drawProjMotFrame()
	{
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
	}
        
	private void drawOpticsFrame(boolean drawLines)
	{
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
            getGraphicsContext2D().setStroke(Color.BLACK);
            //drawing the horizontal line
            getGraphicsContext2D().strokeLine(Constants.ZERO, 
                                              getHeight()/Constants.TWO, 
                                              getWidth(), 
                                              getHeight()/Constants.TWO);
            //drawing the lens - the 2 and 4th parameters represent its height
            getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO,
                                              Constants.LENS_HALF_LENGTH, 
                                              getWidth()/Constants.TWO, 
                                              getHeight() - Constants.LENS_HALF_LENGTH);
            
            //drawing arrow head depending on lens type
            if(Variables.getLensType().equalsIgnoreCase("diverging"))
            {
                //top part of arrow head
                    //left part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Constants.LENS_ARROW_HEAD_LENGTH,
                                                  Constants.LENS_HALF_LENGTH - Constants.LENS_ARROW_HEAD_LENGTH,
                                                  getWidth()/Constants.TWO,
                                                  Constants.LENS_HALF_LENGTH);
                    //right part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO,
                                                  Constants.LENS_HALF_LENGTH,
                                                  getWidth()/Constants.TWO + Constants.LENS_ARROW_HEAD_LENGTH,
                                                  Constants.LENS_HALF_LENGTH - Constants.LENS_ARROW_HEAD_LENGTH);
                //bottom part
                    //left part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Constants.LENS_ARROW_HEAD_LENGTH,
                                                  getHeight() - (Constants.LENS_HALF_LENGTH - Constants.LENS_ARROW_HEAD_LENGTH),
                                                  getWidth()/Constants.TWO,
                                                  getHeight() - Constants.LENS_HALF_LENGTH);
                    //right part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO,
                                                  getHeight() - Constants.LENS_HALF_LENGTH,
                                                  getWidth()/Constants.TWO + Constants.LENS_ARROW_HEAD_LENGTH,
                                                  getHeight() - (Constants.LENS_HALF_LENGTH - Constants.LENS_ARROW_HEAD_LENGTH));                
                
            }
            else if(Variables.getLensType().equalsIgnoreCase("converging"))
            {
                //top part of arrow head
                    //left part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Constants.LENS_ARROW_HEAD_LENGTH,
                                                  Constants.LENS_HALF_LENGTH + Constants.LENS_ARROW_HEAD_LENGTH,
                                                  getWidth()/Constants.TWO,
                                                  Constants.LENS_HALF_LENGTH);
                    //right part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO,
                                                  Constants.LENS_HALF_LENGTH,
                                                  getWidth()/Constants.TWO + Constants.LENS_ARROW_HEAD_LENGTH,
                                                  (Constants.LENS_HALF_LENGTH + Constants.LENS_ARROW_HEAD_LENGTH));
                //bottom part of the arrow head
                    //left part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Constants.LENS_ARROW_HEAD_LENGTH,
                                                  getHeight() - (Constants.LENS_HALF_LENGTH + Constants.LENS_ARROW_HEAD_LENGTH), 
                                                  getWidth()/Constants.TWO, 
                                                  getHeight() - Constants.LENS_HALF_LENGTH);
                    //right part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                  getHeight() - Constants.LENS_HALF_LENGTH, 
                                                  getWidth()/Constants.TWO + Constants.LENS_ARROW_HEAD_LENGTH, 
                                                  getHeight() - (Constants.LENS_HALF_LENGTH + Constants.LENS_ARROW_HEAD_LENGTH));
            }
            
            //drawing focal points, with "F" below each one
            if(Variables.getFocalPoint() != Constants.ZERO)
            {
                getGraphicsContext2D().setFill(Color.BLACK);
                //drawing the first focal point (left of lens)
                    //drawing the first focal line
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getFocalPoint(),
                                                  getHeight()/Constants.TWO - Constants.FOCAL_LINE_HALF_LENGH,
                                                  getWidth()/Constants.TWO - Variables.getFocalPoint(),
                                                  getHeight()/Constants.TWO + Constants.FOCAL_LINE_HALF_LENGH);
                    //drawing the first "F"
                getGraphicsContext2D().fillText(Constants.FOCAL_LETTER_STRING,
                                                getWidth()/Constants.TWO - Variables.getFocalPoint() - Constants.FOCAL_LETTER_HOR_ADJ,
                                                getHeight()/Constants.TWO + Constants.FOCAL_LETTER_VERT_ADJ);
                //drawing the second focal point (right of lens)
                    //drawing the second focal line
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO + Variables.getFocalPoint(),
                                                  getHeight()/Constants.TWO - Constants.FOCAL_LINE_HALF_LENGH,
                                                  getWidth()/Constants.TWO + Variables.getFocalPoint(),
                                                  getHeight()/Constants.TWO + Constants.FOCAL_LINE_HALF_LENGH);
                    //drawing the second "F:
                getGraphicsContext2D().fillText(Constants.FOCAL_LETTER_STRING,
                                                getWidth()/Constants.TWO + Variables.getFocalPoint() - Constants.FOCAL_LETTER_HOR_ADJ,
                                                getHeight()/Constants.TWO + Constants.FOCAL_LETTER_VERT_ADJ);
            }
            
            //drawing object
            if(Variables.getObjDistance()> Constants.ZERO)
            {
                if(Variables.getObjHeight()> Constants.ZERO)
                {
                    getGraphicsContext2D().setStroke(Color.BLUE);
                    //drawing the object itself
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(),
                                                      getHeight()/Constants.TWO, 
                                                      getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                      getHeight()/Constants.TWO - Variables.getObjHeight());
                    //drawing the left part of the arrow head
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance() - Constants.OBJ_IMG_ARROW_HEAD_LENGTH, 
                                                      getHeight()/Constants.TWO - Variables.getObjHeight() + Constants.OBJ_IMG_ARROW_HEAD_LENGTH, 
                                                      getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                      getHeight()/Constants.TWO - Variables.getObjHeight());
                    //drawing the right part of the arrow head
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(),
                                                      getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                      getWidth()/Constants.TWO - Variables.getObjDistance() + Constants.OBJ_IMG_ARROW_HEAD_LENGTH, 
                                                      getHeight()/Constants.TWO - Variables.getObjHeight() + Constants.OBJ_IMG_ARROW_HEAD_LENGTH);
                }
            }
            //Keep drawing these lines
            if(drawLines)
            {
                Variables.setImageDistance(FormulaHelper.computeImageDistance(Variables.getFocalPoint(), Variables.getObjDistance()));
                Variables.setImageHeight(FormulaHelper.computeImageHeight(Variables.getObjHeight(), Variables.getImageDistance(), Variables.getObjDistance()));
                
                //angles
                double thetaCenter = Math.atan(Variables.getObjHeight()/Variables.getObjDistance());
                //angle btw obj height and distance from obj to focal point
                double thetaFocal_1_A = Math.atan(Variables.getObjHeight()/(Variables.getObjDistance() - Variables.getFocalPoint()));
                //angle btw obj height and focal point, given that x = focal length
                double thetaFocal_1_B = Math.atan(Variables.getObjHeight()/(Math.abs(Variables.getFocalPoint())));
                //angle btw obj height and second focal point (as if obj is placed right on lens)
                double thetaFocal_2 = Math.atan(Variables.getObjHeight()/Variables.getFocalPoint());
                
                //line going through middle
                getGraphicsContext2D().setStroke(Color.GREEN);//green for dring the rays
                //first part - line going to middle (is good for both converging and diverging
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                  getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                  getWidth()/Constants.TWO, 
                                                  getHeight()/Constants.TWO);
                
                if(Variables.getLensType().equalsIgnoreCase("converging"))
                {

                    if(Variables.getObjDistance() > Variables.getFocalPoint())
                    {
                        //second part - line going out of middle (for do > f)
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                          getHeight()/Constants.TWO, 
                                                          getWidth(), 
                                                          getHeight()/Constants.TWO + Math.tan(thetaCenter) * Constants.ONE_HALF * getWidth());
                    }
                    else if(Variables.getObjDistance() <= Variables.getFocalPoint())
                    {
                        //second part - line going from obj to left end of screen (for do < f)
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                          Constants.ZERO, 
                                                          getHeight()/Constants.TWO - Math.tan(thetaCenter) * Constants.ONE_HALF * getWidth());
                    }
                    
                    //line going through first focal point
                    //first part, part a - line going to focal point
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                      getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                      getWidth()/Constants.TWO - Variables.getFocalPoint(), 
                                                      getHeight()/Constants.TWO);
                    //first part, part b - line going out of focal point and hitting lens
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getFocalPoint(), 
                                                      getHeight()/Constants.TWO, 
                                                      getWidth()/Constants.TWO, 
                                                      getHeight()/Constants.TWO + Math.tan(thetaFocal_1_A) * Variables.getFocalPoint());
                    
                    if(Variables.getObjDistance() > Variables.getFocalPoint())
                    {
                        //second part - parallel line going out of lens and hitting the right end of canvas (for do > f)
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                      getHeight()/Constants.TWO + Math.tan(thetaFocal_1_A) * Variables.getFocalPoint(), 
                                                      getWidth(), 
                                                      getHeight()/Constants.TWO + Math.tan(thetaFocal_1_A) * Variables.getFocalPoint());
                    }
                    else if(Variables.getObjDistance() <= Variables.getFocalPoint())
                    {
                        //second part - parallel line going out of lens and hitting the left end of canvas (for do <= f)
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                      getHeight()/Constants.TWO + Math.tan(thetaFocal_1_A) * Variables.getFocalPoint(), 
                                                      Constants.ZERO, 
                                                      getHeight()/Constants.TWO + Math.tan(thetaFocal_1_A) * Variables.getFocalPoint());
                    }
                    

                    //line going through second focal point
                    
                    //first part - parallel line hitting lens
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                      getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                      getWidth()/Constants.TWO , 
                                                      getHeight()/Constants.TWO - Variables.getObjHeight());
                    
                    if(Variables.getObjDistance() > Variables.getFocalPoint())
                    {
                        //second part, part a - line going to second focal point
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                          getWidth()/Constants.TWO + Variables.getFocalPoint(), 
                                                          getHeight()/Constants.TWO);
                        //second part, part b - line going through second focal point and hitting the bottom (do > f)
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO + Variables.getFocalPoint(), 
                                                          getHeight()/Constants.TWO, 
                                                          getWidth()/Constants.TWO + Variables.getFocalPoint() + (getHeight()/Constants.TWO)/Math.tan(thetaFocal_2), 
                                                          getHeight());
                    }
                    else if(Variables.getObjDistance() <= Variables.getFocalPoint())
                    {
                        //second part - line going from lens and hitting the left end of the canvas (do <= f)
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight(),
                                                          Constants.ZERO,
                                                          getHeight()/Constants.TWO - Math.tan(thetaFocal_2) * getWidth()/Constants.TWO - Variables.getObjHeight());
                    }
                    
                }
                else if(Variables.getLensType().equalsIgnoreCase("diverging"))
                {
                    //first ray second part - line going out of middle (for do > f)
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                      getHeight()/Constants.TWO, 
                                                      getWidth(), 
                                                      getHeight()/Constants.TWO + Math.tan(thetaCenter) * Constants.ONE_HALF * getWidth());
                    
                    //if(Variables.getObjDistance() > Variables.getFocalPoint())
                    //second ray part one - line going from obj to lens parallel to ground
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                      getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                      getWidth()/Constants.TWO, 
                                                      getHeight()/Constants.TWO - Variables.getObjHeight());
                    
                    //second ray part two - line going from lens to focal point
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                      getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                      getWidth()/Constants.TWO - Math.abs(Variables.getFocalPoint()), 
                                                      getHeight()/Constants.TWO);
                    
                    //second ray part three - line going from lens to focal point
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Math.abs(Variables.getFocalPoint()), 
                                                      getHeight()/Constants.TWO,
                                                      Constants.ZERO,
                                                      getHeight()/Constants.TWO + Math.tan(thetaFocal_1_B) * (getWidth()/Constants.TWO - Math.abs(Variables.getFocalPoint())));
                    
                    //third ray part one - line going from obj to lens
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                      getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                      getWidth()/Constants.TWO, 
                                                      getHeight()/Constants.TWO - Variables.getImageHeight());
                    
                    //third ray part two - line going from lens to left end of canvas, parallel
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                      getHeight()/Constants.TWO - Variables.getImageHeight(),
                                                      Constants.ZERO,
                                                      getHeight()/Constants.TWO - Variables.getImageHeight());
                }
                
                //drawing image
                //set color to red
                getGraphicsContext2D().setStroke(Color.RED);
                //drawing the image itself
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO + Variables.getImageDistance(), 
                                                  getHeight()/Constants.TWO, 
                                                  getWidth()/Constants.TWO + Variables.getImageDistance(),
                                                  getHeight()/Constants.TWO - Variables.getImageHeight());
                //drawing the image's arrow head
                    //drawing the left part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO + Variables.getImageDistance() - Constants.OBJ_IMG_ARROW_HEAD_LENGTH,
                                                  getHeight()/Constants.TWO - Variables.getImageHeight() + ((Variables.getImageHeight() > Constants.ZERO)? Constants.OBJ_IMG_ARROW_HEAD_LENGTH : -Constants.OBJ_IMG_ARROW_HEAD_LENGTH),
                                                  getWidth()/Constants.TWO + Variables.getImageDistance(),
                                                  getHeight()/Constants.TWO - Variables.getImageHeight());
                //drawing the right part of the arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO + Variables.getImageDistance(),
                                                  getHeight()/Constants.TWO - Variables.getImageHeight(),
                                                  getWidth()/Constants.TWO + Variables.getImageDistance() + Constants.OBJ_IMG_ARROW_HEAD_LENGTH,
                                                  getHeight()/Constants.TWO - Variables.getImageHeight() + ((Variables.getImageHeight() > Constants.ZERO)? Constants.OBJ_IMG_ARROW_HEAD_LENGTH : -Constants.OBJ_IMG_ARROW_HEAD_LENGTH));
                
                MainWindow.getTableSection().setRightValue(Constants.ZERO, Variables.getImageDistance());
                MainWindow.getTableSection().setRightValue(Constants.ONE, Variables.getImageHeight());
                MainWindow.getTableSection().setRightValue(Constants.TWO, -Variables.getImageDistance()/Variables.getObjDistance());
                MainWindow.getTableSection().setRightValue(3, ((Variables.getImageDistance() < Constants.ZERO)?Constants.VIRTUAL_LABEL_TEXT:Constants.REAL_LABEL_TEXT));//make the '3' a constant
                
                MainWindow.getGUIControlSection().setDisable(false);
                stop();
            }
            
	}
        
        public void drawOpticsFrame()
        {
            drawOpticsFrame(false);
        }
        
	private void drawThinFilmFrame(boolean drawLines)
	{
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
            if(Variables.getMaterialType().equalsIgnoreCase("water"))
            {
                materialColor = Color.BLUE;
            }
            else if(Variables.getMaterialType().equalsIgnoreCase("glycerin"))
            {
                materialColor = Color.GREY;//make different shade of grey
            }
            else if(Variables.getMaterialType().equalsIgnoreCase("oil"))
            {
                materialColor = Color.GREY;//make different shade of grey
            }
            else if(Variables.getMaterialType().equalsIgnoreCase("zircon"))
            {
                materialColor = Color.LIGHTBLUE;//make bright blue
            }
            else if(Variables.getMaterialType().equalsIgnoreCase("diamond"))
            {
                materialColor = Color.LIGHTGRAY;//make bright shade of grey
            }
            else if(Variables.getMaterialType().equalsIgnoreCase("pyrex"))
            {
                materialColor = Color.LIGHTGRAY;//make an opaque grey
            }
            
            getGraphicsContext2D().setFill(materialColor);
            
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
                    //clear rect for the top part
                    getGraphicsContext2D().clearRect(clearRectLengthReduction, Constants.ZERO, Constants.END_POINT_X_POS - clearRectLengthReduction, topOfFilm);
                    getGraphicsContext2D().setFill(Color.BLACK);
                    //black rect for film
                    getGraphicsContext2D().fillRect(clearRectLengthReduction, topOfFilm, Constants.END_POINT_X_POS - clearRectLengthReduction, Constants.TOP_OF_MATERIAL_Y_POS - topOfFilm);
                    //material color for that little red dot that shouldn't be showing
                    getGraphicsContext2D().setFill(materialColor);
                    getGraphicsContext2D().fillRect(clearRectLengthReduction, Constants.TOP_OF_MATERIAL_Y_POS, Constants.END_POINT_X_POS - clearRectLengthReduction, Constants.ONE);
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
            
            if(priceX_Intercept_1 <= Constants.ZERO || priceX_Intercept_2 <= Constants.ZERO)
            {
                priceX_Intercept_1 = ((-70000 - 200 * Variables.getCostMake()) - Math.sqrt(Math.pow(70000 + 200 * Variables.getCostMake(), Constants.TWO) - 4 * 200 * (Variables.getCostSetUp() + 70000 * Variables.getCostMake())))/(-400);
                priceX_Intercept_2 = ((-70000 - 200 * Variables.getCostMake()) + Math.sqrt(Math.pow(70000 + 200 * Variables.getCostMake(), Constants.TWO) - 4 * 200 * (Variables.getCostSetUp() + 70000 * Variables.getCostMake())))/(-400);
            }
            
            double xAddPoint = deltaX_AddPoint * 15 + priceX_Intercept_2,
                   yAddPoint = -200 * Math.pow(xAddPoint, Constants.TWO) + (70000 + 200 * Variables.getCostMake()) * xAddPoint - (70000 * Variables.getCostMake() + Variables.getCostSetUp());
            
            if(xAddPoint - priceX_Intercept_1 < 100)
            {
              if(yAddPoint < Constants.ZERO)
              {
                  yAddPoint = Constants.ZERO;
              }
              MainWindow.getChartSection().addDataPoint(xAddPoint, yAddPoint, true);
              ++deltaX_AddPoint;
            }
            else
            {
                MainWindow.getGUIControlSection().setDisable(false);
                deltaX_AddPoint = Constants.ZERO;
                priceX_Intercept_1 = Constants.ZERO;
                priceX_Intercept_2 = Constants.ZERO;
                stop();
            }
            
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