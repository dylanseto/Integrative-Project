package sections;


import java.util.concurrent.TimeUnit;

import Main.Constants;
import Main.MainWindow;
import calculations.FormulaHelper;
import calculations.Variables;

import java.text.DecimalFormat;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import sections.animationObjects.CartClass;

public class AnimationSection extends Canvas
{
	//Newton's law and projectile Motion
	private CartClass newtonLawCart;
	private long elapsedTime = System.nanoTime();
	private long initTime;
	private long previousTime;
	private long totalTime;
	private MediaPlayer player;
        
        //for thin film
        private int clearRectLengthReduction = Constants.ZERO;
        private Color materialColor = null;
        
        //for optics
        private int rayGrowthIncrease = Constants.ZERO;
        
        //for all waves things (thin film and optics)
        private int alphaIncrease = Constants.ZERO;
        
        //for new bike
        private double priceX_Intercept_2 = Constants.ZERO,
                       priceX_Intercept_1 = Constants.ZERO;
        private int deltaX_AddPoint = Constants.ZERO,
                    numFrames = Constants.ZERO;
        //private final Image bikeGif = new Image("file:/" + Constants.DIR + "/src/res/bicycle.gif");
        private final Image hoverOverPoint = new Image("file:/" + Constants.DIR + "/src/res/hoverOverPoint.png");
	
	AnimationTimer animTimer = new AnimationTimer(){
		@Override
		public void handle(long time) 
		{
         
			if(initTime == Constants.ZERO)
			{
				initTime = time;
				previousTime = initTime;
			}
			totalTime = time - initTime;
			
			switch(MainWindow.getUserInterface())
			{
				case NO_CHOICE: 
                                    break;
                                    
				case NEWTON_LAW:
								drawNewtonFrame(time);
                                    break;
                                    
				case PROJ_MOTION:
								drawProjMotFrame(time);
                                    break;
                                    
				case OPTICS:
                                    drawOpticsFrame(true);
                                    break;
                                    
				case THIN_FILM:
                                    drawThinFilmFrame(true);
                                    break;
                                    
				case SPORTS_BIKE:
                                    drawNewBikeFrame(true);
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
		this.newtonLawCart = new CartClass(this.getGraphicsContext2D()); //work on this.
		this.initTime = Constants.ZERO;
		this.previousTime = initTime;
		this.player = new MediaPlayer(Constants.maMiaSound);
	}
	private void drawNewtonFrame(long time)
	{
		Variables.setAcceleration(FormulaHelper.computeAccel(Variables.getForce(), Variables.getMass()));
        elapsedTime = time-previousTime;

        Variables.setVelocity(FormulaHelper.computeVelocity(((double)(totalTime))*Constants.NANOSECOND_RATIO, Variables.getAcceleration()));
        
        if(TimeUnit.NANOSECONDS.toSeconds(previousTime-initTime) != TimeUnit.NANOSECONDS.toSeconds(totalTime))
        {
        	
        	
        	MainWindow.getChartSection().addDataPoint(TimeUnit.NANOSECONDS.toSeconds(totalTime), Variables.getVelocity(), true);
        	
        }
        previousTime = time;
        
        Variables.setDisplacement(FormulaHelper.computeDisplacement(((double)(elapsedTime))/1000000000, Variables.getVelocity(), Variables.getDisplacement()));
        newtonLawCart.setX(Variables.getDisplacement()/Constants.METER_RATIO);
        
        if(Variables.getDisplacement()/Constants.METER_RATIO > Constants.X_BOUDARY)
        {
        	this.stop();
        }

        drawNewtonFrame();
	}
	public void drawNewtonFrame()
	{		
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
            newtonLawCart.drawCart();
	}
        
	public void drawProjMotFrame()
	{
		getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
		Image backImage = new Image("file:/" + Constants.DIR + "/src/res/ProjMotBack.png");
		getGraphicsContext2D().drawImage(backImage, 0, 0);
		
		Image canonImage = new Image("file:/" + Constants.DIR + "/src/res/Cannon.png");
        Image canonStandImage = new Image("file:/" + Constants.DIR + "/src/res/CannonStand2.png");
        
        MainWindow.getAnimSection().getGraphicsContext2D().save();
        Rotate r = new Rotate(-Variables.getAngle(), Constants.canonPos_X + canonImage.getWidth() / Constants.TWO, Constants.canonPos_Y + canonImage.getHeight() / Constants.TWO);
        MainWindow.getAnimSection().getGraphicsContext2D().setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        MainWindow.getAnimSection().getGraphicsContext2D().drawImage(canonImage, Constants.canonPos_X, Constants.canonPos_Y);
        MainWindow.getAnimSection().getGraphicsContext2D().restore();
        
        MainWindow.getAnimSection().getGraphicsContext2D().drawImage(canonStandImage, 11, 196);
	}
	private void drawProjMotFrame(long time)
	{   
		elapsedTime = time-previousTime;
        
        
		drawProjMotFrame();
         

		//Make all of these constants.
	
         
         Image projectileImage = new Image("file:/" + Constants.DIR + "/src/res/star.png");
         
         if(Variables.getProjectileType() == Constants.PROJECTILE_TYPE_LIST.get(Constants.ZERO)) // Mario
         {
        	 projectileImage = new Image("file:/" + Constants.DIR + "/src/res/mario.png");
         }
         else if(Variables.getProjectileType() == Constants.PROJECTILE_TYPE_LIST.get(Constants.ONE)) //mushroom
         {
        	 projectileImage = new Image("file:/" + Constants.DIR + "/src/res/mushroom.png");
         }
         else if(Variables.getProjectileType() == Constants.PROJECTILE_TYPE_LIST.get(Constants.TWO)) //Goomba
         {
        	 projectileImage = new Image("file:/" + Constants.DIR + "/src/res/Goomba.png");
         }
         else if(Variables.getProjectileType() == Constants.PROJECTILE_TYPE_LIST.get(Constants.THREE)) //star
         {
        	 projectileImage = new Image("file:/" + Constants.DIR + "/src/res/star.png");
         }
         
		 double initwidth = Constants.initWidth+(Constants.magicNumber*Math.cos(Math.toRadians((Variables.getAngle()))));
         double initHeight = Constants.initHeight-(Constants.magicNumber*Math.sin(Math.toRadians((Variables.getAngle()))));
         
         double HortVel = FormulaHelper.getHorVel(Variables.getAngle(), Variables.getVelocity());
         double VertVel = FormulaHelper.getVertVel(Variables.getAngle(), Variables.getVelocity());
         
         if(TimeUnit.NANOSECONDS.toSeconds(previousTime-initTime) != TimeUnit.NANOSECONDS.toSeconds(totalTime))
	        {
	        	
	        	
	        	MainWindow.getChartSection().addDataPoint(TimeUnit.NANOSECONDS.toSeconds(totalTime), Variables.getHeight(), true);
	        	
	        }
         previousTime = time;
    
         Variables.setDisplacement(FormulaHelper.computeDisplacement(((double)(elapsedTime))*Constants.NANOSECOND_RATIO, HortVel, Variables.getDisplacement()));
         Variables.setHeight(FormulaHelper.computeCurrentHeight(((double)(totalTime))*Constants.NANOSECOND_RATIO, VertVel, Variables.getHeight(), Variables.getGravity()));
         getGraphicsContext2D().drawImage(projectileImage, initwidth+(Variables.getDisplacement()), (initHeight-(Variables.getHeight()*10)));
         
         if(initwidth+(Variables.getDisplacement()) > Constants.X_BOUDARY || initwidth+(Variables.getHeight()) < Constants.Y_BOUNDARY||initwidth+(Variables.getHeight()) > 300)
         {
        	 this.stop();
         }
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
            double heightPoint;
            
            if(Math.abs(Variables.getImageHeight()) > Constants.LENS_MIN_HALF_LENGTH)
            {
                heightPoint = getHeight()/Constants.TWO - Math.abs(Variables.getImageHeight());
            }
            else if(Variables.getObjHeight() >= getHeight()/Constants.TWO)
            {
                //make the lens height the height of the canvas
                heightPoint = Constants.ZERO + ((Variables.getLensType().equalsIgnoreCase(Constants.LENS_DIVERGING))
                                  ? Constants.LENS_ARROW_HEAD_LENGTH
                                  : Constants.ZERO);
            }
            else if(Variables.getObjHeight() >= Constants.LENS_MIN_HALF_LENGTH)
            {
                //make the lens height the size of the object
                heightPoint = getHeight()/Constants.TWO - Variables.getObjHeight();
            }
            else
            {
                //make the lens height the constant height
                heightPoint = Constants.LENS_MIN_HALF_LENGTH;
                
            }
            //draw the line with the decided positions
            getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO,
                                              heightPoint, 
                                              getWidth()/Constants.TWO, 
                                              getHeight() - heightPoint);
            
            //drawing arrow head depending on lens type
            if(Variables.getLensType().equalsIgnoreCase(Constants.LENS_DIVERGING))
            {
                //top part of arrow head
                    //left part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Constants.LENS_ARROW_HEAD_LENGTH,
                                                  heightPoint - Constants.LENS_ARROW_HEAD_LENGTH,
                                                  getWidth()/Constants.TWO,
                                                  heightPoint);
                    //right part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO,
                                                  heightPoint,
                                                  getWidth()/Constants.TWO + Constants.LENS_ARROW_HEAD_LENGTH,
                                                  heightPoint - Constants.LENS_ARROW_HEAD_LENGTH);
                //bottom part
                    //left part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Constants.LENS_ARROW_HEAD_LENGTH,
                                                  getHeight() - (heightPoint - Constants.LENS_ARROW_HEAD_LENGTH),
                                                  getWidth()/Constants.TWO,
                                                  getHeight() - heightPoint);
                    //right part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO,
                                                  getHeight() - heightPoint,
                                                  getWidth()/Constants.TWO + Constants.LENS_ARROW_HEAD_LENGTH,
                                                  getHeight() - (heightPoint - Constants.LENS_ARROW_HEAD_LENGTH));                
                
            }
            else if(Variables.getLensType().equalsIgnoreCase(Constants.LENS_CONVERGING))
            {
                //top part of arrow head
                    //left part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Constants.LENS_ARROW_HEAD_LENGTH,
                                                  heightPoint + Constants.LENS_ARROW_HEAD_LENGTH,
                                                  getWidth()/Constants.TWO,
                                                  heightPoint);
                    //right part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO,
                                                  heightPoint,
                                                  getWidth()/Constants.TWO + Constants.LENS_ARROW_HEAD_LENGTH,
                                                  (heightPoint + Constants.LENS_ARROW_HEAD_LENGTH));
                //bottom part of the arrow head
                    //left part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Constants.LENS_ARROW_HEAD_LENGTH,
                                                  getHeight() - (heightPoint + Constants.LENS_ARROW_HEAD_LENGTH), 
                                                  getWidth()/Constants.TWO, 
                                                  getHeight() - heightPoint);
                    //right part of arrow head
                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                  getHeight() - heightPoint, 
                                                  getWidth()/Constants.TWO + Constants.LENS_ARROW_HEAD_LENGTH, 
                                                  getHeight() - (heightPoint + Constants.LENS_ARROW_HEAD_LENGTH));
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
            
            if(drawLines)
            {
                MainWindow.getTableSection().setRightValue(Constants.ZERO, Constants.EMPTY_STRING);
                MainWindow.getTableSection().setRightValue(Constants.ONE, Constants.EMPTY_STRING);
                MainWindow.getTableSection().setRightValue(Constants.TWO, Constants.EMPTY_STRING);
                MainWindow.getTableSection().setRightValue(Constants.THREE, Constants.EMPTY_STRING);
                       
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

                if(rayGrowthIncrease <= Constants.ONE_HUNDRED)
                {
                   //first part - line going to middle (is good for both converging and diverging
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                      getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                      getWidth()/Constants.TWO - Variables.getObjDistance() +
                                                      ((double)(rayGrowthIncrease)) * (Variables.getObjDistance())/Constants.ONE_HUNDRED,
                                                      getHeight()/Constants.TWO - Variables.getObjHeight() +
                                                      ((double)(rayGrowthIncrease)) * (Variables.getObjHeight())/Constants.ONE_HUNDRED); 
                }
                else
                {
                    //first part - line going to middle (is good for both converging and diverging
                    getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                      getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                      getWidth()/Constants.TWO,
                                                      getHeight()/Constants.TWO); 
                }

                
                if(Variables.getLensType().equalsIgnoreCase(Constants.LENS_CONVERGING))
                {
                    if(rayGrowthIncrease >= Constants.ONE_HUNDRED)
                    {
                        if(Variables.getObjDistance() > Variables.getFocalPoint())
                        {
                            //second part - line going out of middle (for do > f)
                            if(rayGrowthIncrease <= Constants.TWO_HUNDRED)
                            {
                                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                              getHeight()/Constants.TWO, 
                                                              getWidth()/Constants.TWO + 
                                                              ((double)(rayGrowthIncrease - Constants.ONE_HUNDRED))*((getWidth()/Constants.TWO)/Constants.ONE_HUNDRED), 
                                                              getHeight()/Constants.TWO + 
                                                              (double)(rayGrowthIncrease - Constants.ONE_HUNDRED)*(Math.tan(thetaCenter) * Constants.ONE_HALF * getWidth())/Constants.ONE_HUNDRED);
                            }
                            else
                            {
                                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                              getHeight()/Constants.TWO, 
                                                              getWidth(), 
                                                              getHeight()/Constants.TWO + Math.tan(thetaCenter) * Constants.ONE_HALF * getWidth());
                            }
                        }
                        else if(Variables.getObjDistance() <= Variables.getFocalPoint())
                        {
                            if(rayGrowthIncrease <= Constants.TWO_HUNDRED)
                            {
                                //the whole line going from obj to lens
                                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                                  (getHeight()/Constants.TWO - Variables.getObjHeight()), 
                                                                  getWidth()/Constants.TWO - Variables.getObjDistance()
                                                                   - (double)(rayGrowthIncrease - Constants.ONE_HUNDRED)* (getWidth()/Constants.TWO - Variables.getObjDistance())/Constants.ONE_HUNDRED,
                                                                  getHeight()/Constants.TWO - Variables.getObjHeight() - 
                                                                 (double)(rayGrowthIncrease - Constants.ONE_HUNDRED)*(Math.tan(thetaCenter) * (getWidth()/Constants.TWO - Variables.getObjDistance()))/Constants.ONE_HUNDRED);
                            }
                            else
                            {
                            //second part - line going from obj to left end of screen (for do < f)
                            getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                              getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                              Constants.ZERO, 
                                                              getHeight()/Constants.TWO - Math.tan(thetaCenter) * Constants.ONE_HALF * getWidth());
                            }
                        }
                    }
                    
                    
                    //line going through first focal point
                    if(rayGrowthIncrease <= Constants.ONE_HUNDRED)
                    {
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight(),
                                                          getWidth()/Constants.TWO - Variables.getObjDistance()
                                                          + ((double)(rayGrowthIncrease)) * (Variables.getObjDistance()/Constants.ONE_HUNDRED), 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight()
                                           + ((double)(rayGrowthIncrease)) * (Math.tan(thetaFocal_1_A) * Variables.getObjDistance())/Constants.ONE_HUNDRED);
                    
                        
                        if(Variables.getObjDistance() <= Variables.getFocalPoint())
                        {
                            //first part, part a - line going to focal point (for do < f)
                            getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                              getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                              getWidth()/Constants.TWO - Variables.getObjDistance()
                                                          - ((double)(rayGrowthIncrease)) * ((Variables.getFocalPoint() - Variables.getObjDistance())/Constants.ONE_HUNDRED), 
                                                              getHeight()/Constants.TWO - Variables.getObjHeight()
                                                          + ((double)(rayGrowthIncrease)) * (Variables.getObjHeight()/Constants.ONE_HUNDRED));
                        }
                        
                    
                    }
                    else
                    {

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
                    }
                    
                    if(rayGrowthIncrease >= Constants.ONE_HUNDRED)
                    {
                        if(Variables.getObjDistance() > Variables.getFocalPoint())
                        {
                            if(rayGrowthIncrease <= Constants.TWO_HUNDRED)
                            {
                                //second part - parallel line going out of lens and hitting the right end of canvas (for do > f)
                                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                              getHeight()/Constants.TWO + Math.tan(thetaFocal_1_A) * Variables.getFocalPoint(), 
                                                              getWidth()/Constants.TWO
                                        + ((double)(rayGrowthIncrease - Constants.ONE_HUNDRED)) * (getWidth()/Constants.TWO)/Constants.ONE_HUNDRED, 
                                                              getHeight()/Constants.TWO + Math.tan(thetaFocal_1_A) * Variables.getFocalPoint());
                            }
                            else
                            {
                                //second part - parallel line going out of lens and hitting the right end of canvas (for do > f)
                                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                              getHeight()/Constants.TWO + Math.tan(thetaFocal_1_A) * Variables.getFocalPoint(), 
                                                              getWidth(), 
                                                              getHeight()/Constants.TWO + Math.tan(thetaFocal_1_A) * Variables.getFocalPoint());
                            }
                        }
                        else if(Variables.getObjDistance() <= Variables.getFocalPoint())
                        {
                            if(rayGrowthIncrease <= Constants.TWO_HUNDRED)
                            {
                                //second part - parallel line going out of lens and hitting the left end of canvas (for do <= f)
                                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                              getHeight()/Constants.TWO + Math.tan(thetaFocal_1_A) * Variables.getFocalPoint(), 
                                                              getWidth()/Constants.TWO
                                        - ((double)(rayGrowthIncrease - Constants.ONE_HUNDRED)) * (getWidth()/Constants.TWO)/Constants.ONE_HUNDRED, 
                                                              getHeight()/Constants.TWO + Math.tan(thetaFocal_1_A) * Variables.getFocalPoint());
                            }
                            else
                            {
                                //second part - parallel line going out of lens and hitting the left end of canvas (for do <= f)
                                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                              getHeight()/Constants.TWO + Math.tan(thetaFocal_1_A) * Variables.getFocalPoint(), 
                                                              Constants.ZERO, 
                                                              getHeight()/Constants.TWO + Math.tan(thetaFocal_1_A) * Variables.getFocalPoint());
                            }
                        }
                    }
                    
                    //line going through second focal point
                    
                    if(rayGrowthIncrease <= Constants.ONE_HUNDRED)
                    {
                        //first part - parallel line hitting lens
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                          getWidth()/Constants.TWO - Variables.getObjDistance()
                                + ((double)(rayGrowthIncrease)) * (Variables.getObjDistance())/Constants.ONE_HUNDRED, 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight());
                    }
                    else
                    {
                        //first part - parallel line hitting lens
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                          getWidth()/Constants.TWO , 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight());
                    }
                    
                    if(rayGrowthIncrease >= Constants.ONE_HUNDRED)
                    {
                        if(Variables.getObjDistance() > Variables.getFocalPoint())
                        {
                            if(rayGrowthIncrease <= Constants.TWO_HUNDRED)
                            {
                                //line going from lens directly to bottom
                                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                                  getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                                  getWidth()/Constants.TWO
                                        + ((double)(rayGrowthIncrease - Constants.ONE_HUNDRED)) * ((getHeight()/Constants.TWO + Variables.getObjHeight())/Math.tan(thetaFocal_2))/Constants.ONE_HUNDRED, 
                                                                  getHeight()/Constants.TWO - Variables.getObjHeight()
                                + ((double)(rayGrowthIncrease - Constants.ONE_HUNDRED)) * (getHeight()/Constants.TWO + Variables.getObjHeight())/Constants.ONE_HUNDRED);
                            }
                            else
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
                        }
                        else if(Variables.getObjDistance() <= Variables.getFocalPoint())
                        {
                            if(rayGrowthIncrease <= Constants.TWO_HUNDRED)
                            {
                                //second part - line going from lens and hitting the left end of the canvas (do <= f)
                                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                                  getHeight()/Constants.TWO - Variables.getObjHeight(),
                                                                  getWidth()/Constants.TWO
                                        - ((double)(rayGrowthIncrease - Constants.ONE_HUNDRED)) * (getWidth()/Constants.TWO)/Constants.ONE_HUNDRED,
                                                                  getHeight()/Constants.TWO - Variables.getObjHeight()
                                        - ((double)(rayGrowthIncrease - Constants.ONE_HUNDRED)) * (Math.tan(thetaFocal_2) * getWidth()/Constants.TWO)/Constants.ONE_HUNDRED);
                            }
                            else
                            {
                                //second part - line going from lens and hitting the left end of the canvas (do <= f)
                                getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                                  getHeight()/Constants.TWO - Variables.getObjHeight(),
                                                                  Constants.ZERO,
                                                                  getHeight()/Constants.TWO - Math.tan(thetaFocal_2) * getWidth()/Constants.TWO - Variables.getObjHeight());
                            }
                        }
                    }
                }
                else if(Variables.getLensType().equalsIgnoreCase(Constants.LENS_DIVERGING))
                {
                    //second part - line going out of middle
                    if(rayGrowthIncrease >= Constants.ONE_HUNDRED)
                    {
                        if(rayGrowthIncrease <= Constants.TWO_HUNDRED)
                        {
                            getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                          getHeight()/Constants.TWO, 
                                                          getWidth()/Constants.TWO + 
                                                          ((double)(rayGrowthIncrease - Constants.ONE_HUNDRED))*((getWidth()/Constants.TWO)/Constants.ONE_HUNDRED), 
                                                          getHeight()/Constants.TWO + 
                                                          (double)(rayGrowthIncrease - Constants.ONE_HUNDRED)*(Math.tan(thetaCenter) * Constants.ONE_HALF * getWidth())/Constants.ONE_HUNDRED);
                        }
                        else
                        {
                            getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                          getHeight()/Constants.TWO, 
                                                          getWidth(), 
                                                          getHeight()/Constants.TWO + Math.tan(thetaCenter) * Constants.ONE_HALF * getWidth());
                        }
                    }
                    
                    
                    //second ray part one - line going from obj to lens parallel to ground
                    if(rayGrowthIncrease <= Constants.ONE_HUNDRED)
                    {
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight(), 
                               getWidth()/Constants.TWO - Variables.getObjDistance() + ((double)(rayGrowthIncrease)) * (Variables.getObjDistance())/Constants.ONE_HUNDRED, 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight());
                    }
                    else
                    {
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                          getWidth()/Constants.TWO, 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight());
                    }
                    
                    //second ray part twp - line going from lens through focal point and hitting screen
                    if(rayGrowthIncrease >= Constants.ONE_HUNDRED)
                    {
                        if(rayGrowthIncrease <= Constants.TWO_HUNDRED)
                        {
                            getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                              getHeight()/Constants.TWO - Variables.getObjHeight(),
                                   getWidth()/Constants.TWO - ((double)(rayGrowthIncrease - Constants.ONE_HUNDRED)) * (getWidth()/Constants.TWO)/Constants.ONE_HUNDRED,
                         getHeight()/Constants.TWO - Variables.getObjHeight() + ((double)(rayGrowthIncrease - Constants.ONE_HUNDRED)) * (Variables.getObjHeight() + Math.tan(thetaFocal_1_B) * (getWidth()/Constants.TWO - Math.abs(Variables.getFocalPoint())))/Constants.ONE_HUNDRED);
                        }
                        else
                        {
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
                        }
                    }
                    
                    //third ray part one - line going from obj to lens
                    if(rayGrowthIncrease <= Constants.ONE_HUNDRED)
                    {
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                       getWidth()/Constants.TWO - Variables.getObjDistance() + ((double)(rayGrowthIncrease)) *(Variables.getObjDistance())/Constants.ONE_HUNDRED, 
                                       getHeight()/Constants.TWO - Variables.getObjHeight() + ((double)(rayGrowthIncrease)) *(Math.abs(Variables.getObjHeight() - Variables.getImageHeight()))/Constants.ONE_HUNDRED);
                    }
                    else
                    {
                        getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO - Variables.getObjDistance(), 
                                                          getHeight()/Constants.TWO - Variables.getObjHeight(), 
                                                          getWidth()/Constants.TWO, 
                                                          getHeight()/Constants.TWO - Variables.getImageHeight());
                    }
                    

                    //third ray part two - line going from lens to left end of canvas, parallel
                    if(rayGrowthIncrease >= Constants.ONE_HUNDRED)
                    {
                        if(rayGrowthIncrease <= Constants.TWO_HUNDRED)
                        {
                            getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                              getHeight()/Constants.TWO - Variables.getImageHeight(),
                                     getWidth()/Constants.TWO - ((double)(rayGrowthIncrease - Constants.ONE_HUNDRED)) * (getWidth()/Constants.TWO)/Constants.ONE_HUNDRED,
                                                              getHeight()/Constants.TWO - Variables.getImageHeight());
                        }
                        else
                        {
                            getGraphicsContext2D().strokeLine(getWidth()/Constants.TWO, 
                                                              getHeight()/Constants.TWO - Variables.getImageHeight(),
                                                              Constants.ZERO,
                                                              getHeight()/Constants.TWO - Variables.getImageHeight());
                        }
                    }
                }
                
                if(rayGrowthIncrease <= Constants.TWO_HUNDRED)
                {
                    ++rayGrowthIncrease;
                }
                else if(rayGrowthIncrease > Constants.TWO_HUNDRED)
                {
                    //drawing image

                    //set color to red (with fade)
                    getGraphicsContext2D().setStroke(Color.rgb(Constants.MAX_RGB_VALUE, Constants.ZERO, Constants.ZERO, ((double)alphaIncrease)/Constants.ONE_HUNDRED));

                    //set fade value for next frame
                    if(alphaIncrease < Constants.ONE_HUNDRED)
                    {
                        ++alphaIncrease;
                    }
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

                    if(alphaIncrease >= Constants.ONE_HUNDRED)
                    {
                       MainWindow.getTableSection().setRightValue(Constants.ZERO, Variables.getImageDistance());
                       MainWindow.getTableSection().setRightValue(Constants.ONE, Variables.getImageHeight());
                       MainWindow.getTableSection().setRightValue(Constants.TWO, -Variables.getImageDistance()/Variables.getObjDistance());
                       MainWindow.getTableSection().setRightValue(Constants.THREE, ((Variables.getImageDistance() < Constants.ZERO)?Constants.VIRTUAL_LABEL_TEXT:Constants.REAL_LABEL_TEXT));
                       alphaIncrease = Constants.ZERO;
                       rayGrowthIncrease = Constants.ZERO;
                       MainWindow.getGUIControlSection().setDisable(false);
                       stop(); 
                    }
                }
                
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
                    
                    getGraphicsContext2D().setFill(Color.rgb(Constants.ZERO, Constants.ZERO, Constants.ZERO, (double)(alphaIncrease)/Constants.ONE_HUNDRED));
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
                    
                    
                    if(alphaIncrease < Constants.ONE_HUNDRED)
                    {
                        ++alphaIncrease;
                    }
                    else if(alphaIncrease >= Constants.ONE_HUNDRED)
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
                        alphaIncrease = Constants.ZERO;
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
        
	private void drawNewBikeFrame(boolean isGraphRunning)
	{
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());  

            if(isGraphRunning)
            {
                
                if(priceX_Intercept_2 <= Constants.ZERO || priceX_Intercept_1 <= Constants.ZERO)
                {
                    priceX_Intercept_2 = ((-70000 - 200 * Variables.getCostMake()) - Math.sqrt(Math.pow(70000 + 200 * Variables.getCostMake(), Constants.TWO) - 4 * 200 * (Variables.getCostSetUp() + 70000 * Variables.getCostMake())))/(-400);
                    priceX_Intercept_1 = ((-70000 - 200 * Variables.getCostMake()) + Math.sqrt(Math.pow(70000 + 200 * Variables.getCostMake(), Constants.TWO) - 4 * 200 * (Variables.getCostSetUp() + 70000 * Variables.getCostMake())))/(-400);
                }

                if((numFrames++)%20 == Constants.ZERO)
                {
                    double xAddPoint = deltaX_AddPoint * 15 + priceX_Intercept_1,
                           yAddPoint = -200 * Math.pow(xAddPoint, Constants.TWO) + (70000 + 200 * Variables.getCostMake()) * xAddPoint - (70000 * Variables.getCostMake() + Variables.getCostSetUp());

                    if(xAddPoint - priceX_Intercept_2 < 20)
                    {
                      if(yAddPoint < Constants.ZERO)
                      {
                          yAddPoint = Constants.ZERO;
                          xAddPoint = priceX_Intercept_2;
                      }
                      MainWindow.getChartSection().addDataPoint(xAddPoint, yAddPoint, true);
                        if(MainWindow.getChartSection().getData().get(Constants.ZERO).getData().get(Constants.ZERO).getXValue().doubleValue() >= priceX_Intercept_2)
                        {
                            MainWindow.getChartSection().getData().get(Constants.ZERO).getData().remove(MainWindow.getChartSection().getData().get(Constants.ZERO).getData().get(Constants.ZERO));
                        }
                      ++deltaX_AddPoint;
                    }
                    else
                    {
                        MainWindow.getGUIControlSection().setDisable(true);
                        deltaX_AddPoint = Constants.ZERO;
                        priceX_Intercept_2 = Constants.ZERO;
                        priceX_Intercept_1 = Constants.ZERO;
                        //MainWindow.getChartSection().getData().get(Constants.ZERO) -> this returns the observable list carrying the series plotted
                        //.getData().size() -> this returns the observable list carrying the data points of said series
                        for(int i = Constants.ZERO; i < MainWindow.getChartSection().getData().get(Constants.ZERO).getData().size(); ++i)
                        {
                            double profitOfThisPoint = MainWindow.getChartSection().getData().get(Constants.ZERO).getData().get(i).getYValue().doubleValue();
                            if(Variables.getMaxProfit() < profitOfThisPoint)
                            {
                                Variables.setMaxProfit(profitOfThisPoint);
                            }
                        }

                        getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
                        drawNewBikeFrame();
                        stop();
                    }
                }
            }
            else
            {
                getGraphicsContext2D().drawImage(hoverOverPoint, Constants.ZERO, Constants.ZERO);
            }
            
        }
        
        
        public void drawNewBikeFrame(double salePrice, double profit)
        {
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
            
            //draw money pile
            double profitRatio = profit/Variables.getMaxProfit();
            Image moneyImage = new Image("file:/" + Constants.DIR + "/src/res/moneyPile.png", profitRatio * Constants.MONEY_PILE_MAX_WIDTH, profitRatio * Constants.MONEY_PILE_MAX_HEIGHT, false, true);
            getGraphicsContext2D().drawImage(moneyImage, (getWidth() - moneyImage.getRequestedWidth())/Constants.TWO, getHeight() - moneyImage.getRequestedHeight());
            
            //draw text at the top
            getGraphicsContext2D().setFill(Color.BLACK);
            getGraphicsContext2D().fillText("Sale price = " + Constants.FORMATTER.format(salePrice) + "$\nNumber of units to sell = " + (int)(70000 - 200*salePrice)
                                            + "\nPotential profit = " + Constants.FORMATTER.format(profit) + "$", 75, 15);
        }
        
        public void drawNewBikeFrame()
        {
            drawNewBikeFrame(false);
        }
        
	private void drawInfSeriesFrame()
	{
            getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, getWidth(), getHeight());
	}
        
	public void start()
	{
            if(MainWindow.getUserInterface() == Constants.UserInterface.NEWTON_LAW
            		||MainWindow.getUserInterface() == Constants.UserInterface.PROJ_MOTION)
            {
                MainWindow.getChartSection().addDataPoint(Constants.ZERO, Constants.ZERO);
                
                if(MainWindow.getUserInterface() == Constants.UserInterface.PROJ_MOTION)
                {
                	if(Variables.getProjectileType() == Constants.PROJECTILE_TYPE_LIST.get(0))
                	{
                		this.player = new MediaPlayer(Constants.maMiaSound);
                	}
                	else if(Variables.getProjectileType() == Constants.PROJECTILE_TYPE_LIST.get(1)) //mushroom
                	{
                		this.player = new MediaPlayer(Constants.mushaSound);
                	}
                	else if(Variables.getProjectileType() == Constants.PROJECTILE_TYPE_LIST.get(2)) //goomba
                	{
                		this.player = new MediaPlayer(Constants.goombaSound);
                	}
                	else if(Variables.getProjectileType() == Constants.PROJECTILE_TYPE_LIST.get(3)) //star
                	{
                		this.player = new MediaPlayer(Constants.starSound);
                	}
                	this.player.play();
                }
   
                System.out.println("deg");
            }
            
            MainWindow.getGUIControlSection().getValues();
            this.animTimer.start();
	}
        
	public void stop()
	{
		this.animTimer.stop();
		MainWindow.getGUIControlSection().setDisable(false);
		
		this.initTime = Constants.ZERO;
		this.previousTime = initTime;
		
	}
        
	public void reset()
	{
		if(MainWindow.getUserInterface() == Constants.UserInterface.NEWTON_LAW)
        {
			MainWindow.getChartSection().clearData();
			
			//Reset all Variables to default values.
			Variables.setAcceleration(Constants.ZERO);
			Variables.setDisplacement(Constants.ZERO);
			Variables.setVelocity(Constants.ZERO);
			this.newtonLawCart.setX(Constants.ZERO);
			
			this.drawNewtonFrame();
        }
		else if(MainWindow.getUserInterface() == Constants.UserInterface.PROJ_MOTION)
        {
			MainWindow.getChartSection().clearData();
			
			//Reset all Variables to default values.
			Variables.setAcceleration(Constants.ZERO);
			Variables.setDisplacement(Constants.ZERO);
			Variables.setVelocity(Constants.ZERO);
			Variables.setHeight(Constants.ZERO);
			Variables.setAngle(0);
			this.player.stop();
			
			this.drawProjMotFrame();
        }
		
	}
}