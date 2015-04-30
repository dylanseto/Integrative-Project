package Main;

import java.io.File;
import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.media.Media;

public interface Constants
{
        //general
	public final int ZERO = 0;
	public final int ONE = 1;
        public final int TWO = 2;
        public final int THREE = 3;
        public final int FOUR = 4;
        public final int FIVE = 5;
        public final int SIX = 6;
        public final int SEVEN = 7;
        public final int EIGHT = 8;
        public final int ONE_HUNDRED = 100;
        public final int TWO_HUNDRED = 200;
	public final double ONE_HALF = 0.5;
        public final String EMPTY_STRING = "";
        public final int MAX_RGB_VALUE = 255;
        public final String DIR = System.getProperty("user.dir");
        public final DecimalFormat FORMATTER = new DecimalFormat("#0.00");
        public final int GUI_SPACING = 10;
        public final String NUMBERS_ONLY_REGEX = "^[0-9\\.]*$";
        public final int FONT_SIZE = 12;

	//Index of Refraction
	public final double INDEX_REF_AIR = 1.0003;
	public final double INDEX_REF_WATER = 1.333;
	public final double INDEX_REF_GLYCERIN = 1.473;
	public final double INDEX_REF_OIL = 1.515;
	public final double INDEX_REF_ZIRCON = 1.920;
	public final double INDEX_REF_DIAMOND = 2.417;
	public final double INDEX_REF_PYREX = 1.470;
        
        //visible light range (in nm)
        public final double MIN_VIS_LIGHT_LENGTH = 400;
        public final double MAX_VIS_LIGHT_LENGTH = 700;
        
	//Sizing ratios
	public final double METER_RATIO = 0.01;
	public final double SCREEN_SPLIT_RATIO = 0.5;

	//Combo Box options
	public final String OPTION_MECHANICS = "Mechanics";
	public final String OPTION_WAVES = "Waves";
	public final String OPTION_CALCULUS = "Calculus";
	public final String OPTION_EXIT = "Exit";
        
        //Button options
        public final String OPTION_NEWTON = "Newton's Second\nLaw";
        public final String OPTION_PROJ_MOT = "Projectile Motion";
        public final String OPTION_OPTICS = "Optics";
        public final String OPTION_THIN_FILM = "Thin Film";
        public final String OPTION_NEW_BIKE = "New Sports Bike";
        public final String OPTION_INF_GEOM = "Infinite Geometric\nSeries";
        public final String CONFIRM_EXIT_MSG = "Are you sure you want to exit?";
        public final String OPTION_YES = "Yes"; 
        public final String OPTION_NO = "No";
        
        //Main menu button texts
        public final String START_BUTTON = "Start";
        public final String PAUSE_BUTTON = "Pause";
        public final String RESET_BUTTON = "Reset";
        public final String HELP_BUTTON  = "Help";
        public final String DONE_BUTTON  = "Done";
        public final String CONTINUE_BUTTON = "Continue";
        
        //Help messages
        public final String NEWTON_HELP_MSG = "Description: During this animation, a car will\nmove according to newton's second law in relation\nto the specified mass and force. The velocity and acceleration\n will calculated according to F=ma.\n\nMass: The specified mass of the car in kilograms.\nForce: The specified force in Newtons.";
        public final String PROJ_MOT_HELP_MSG = "Description: During this animation, you will\nwatch a cannon shoot a specified projectile according\nto the specified gravity, angle and velocity of the object being launched.\n\nProjectile: The type of projectile you want to throw. This has no effect\n on the launch.\nGravity: The specified gravity constant to use.\nAngle: The angle of the cannon in degrees.\nInitial Velocty: The initial velocity of the projectile.";
        public final String OPTICS_HELP_MSG = "";
        public final String THIN_FILM_HELP_MSG = "";
        public final String NEW_BIKE_HELP_MSG = "";
        public final String INF_GEOM_HELP_MSG = "Description: During this animation, the sides\nof a square will grow in size according the value\nof term each  in the sum. You may notice that if the base\n is 0, there will be no growth. If the base in below\n 1 (excluding), the size of the square will eventually\n stabilize and if the square is 1 or above, it will\n increase indefinitely.\n\nCoefficent: A number, in an equation a(x^k), this is the a value.\nBase: A number, in an equation a(x^k), this is the x value.\nExponent: A number. This determines how many terms we should calculate.";
        
        //GUISection label texts
        public final String ENTER_VAL_LABEL_TEXT = "Enter Values";
        public final String FORCE_LABEL_TEXT = "Force (N): ";
        public final String MASS_LABEL_TEXT = "Mass (kg): ";
        public final String INIT_VEL_LABEL_TEXT = "Initial Velocity (m/s) : ";
        public final String OBJECT_LABEL_TEXT = "Object";
        public final String GRAVITY_LABEL_TEXT = "Gravity = ";
        public final String ANGLE_LABEL_TEXT = "Angle (degrees): ";
        public final String IMAGE_LABEL_TEXT = "Image";
        public final String IMG_DIST_LABEL_TEXT = "Distance";
        public final String IMG_HEIGHT_LABEL_TEXT = "Height:";
        public final String MAGNIFICATION_LABEL_TEXT = "Magnification";
        public final String REAL_OR_VIRT_LABEL_TEXT = "Real or Virtual?";
        public final String REAL_LABEL_TEXT = "Real";
        public final String VIRTUAL_LABEL_TEXT = "Virtual";
        public final String LENS_LABEL_TEXT = "Lens type:";
        public final String OBJ_HEIGHT_LABEL_TEXT = "Object height: ";
        public final String OBJ_DIST_LABEL_TEXT = "Object distance: ";
        public final String FOCAL_DIST_LABEL_TEXT = "Focal distance: ";
        public final String WAVE_LENGTHS_LABEL_TEXT = "Wavelengths Within Visible \nLight Range (400nm - 700nm)";
        public final String ENHANCED_LABEL_TEXT = "Enhanced";
        public final String DESTROYED_LABEL_TEXT = "Destroyed";
        public final String MATERIAL_LABEL_TEXT = "Material:";
        public final String INDEX_REF_MAT_LABEL_TEXT = "nm = ";
        public final String THICKNESS_LABEL_TEXT = "Thickness: ";
        public final String COST_SET_UP_LABEL_TEXT = "Setup costs: ";
        public final String COST_BIKE_LABEL_TEXT = "Bike cost: ";
        public final String COEFF_LABEL_TEXT = "Coefficient: ";
        public final String BASE_LABEL_TEXT = "Base: ";
        public final String EXPONENT_LABEL_TEXT = "Exponent: ";
        public final String INDEX_REF_FILM_TEXT = "Index Of \nRefraction Of Film: ";
        
        //Graph labels
        public final int GRAPH_TITLE_INDEX = 0;
        public final int GRAPH_Y_AXIS_INDEX = 1;
        public final int GRAPH_X_AXIS_INDEX = 2;
        public final String[] NEWTON_GRAPH_LABELS = {"Velocity vs. Time", "Velocity (m/s)", "Time (s)"};
        public final String[] PROJ_MOT_GRAPH_LABELS = {"Vertical Displacement vs. Time", "Time (s)", "Vertical Displacement (m)"};
        public final String[] NEW_BIKE_GRAPH_LABELS = {"Profit vs. Sale Price", "Sale Price ($)", "Profit ($)"};
        public final String[] INF_GEOM_GRAPH_LABELS = {"Partial Sum vs. Term Number", "Partial Sum", "Term Number"};
        
        //TableSection constants
        public final String RIGHT_VALUE = "rightValue";
        public final String LEFT_VALUE  = "leftValue";

	public enum UserInterface
	{
		NO_CHOICE,
		NEWTON_LAW,
		PROJ_MOTION,
		OPTICS,
		THIN_FILM,
		SPORTS_BIKE,
		INF_GEOM_SERIES
	}
        
	//Gravity constants
	public final double GRAVITY_NOTHING = 0;
	public final double GRAVITY_EARTH = 9.80665;
	public final double GRAVITY_SUPERMARIO = 91.28;
	public final double GRAVITY_SUPERMARIO2 = 107.95;
	public final double GRAVITY_SUPERMARIO3 = 92.31;
	public final double GRAVITY_SUPERWORLD = 61.92;
	public final double GRAVITY_MARIOSUNSHINE = 43.05;
	public final double GRAVITY_SUPERPAPER = 49.47;
	public final double GRAVITY_SUPERMARIO64 = 69.22;
        
        //Combobox observable lists
        public final ObservableList<String> PROJECTILE_TYPE_LIST = FXCollections.observableArrayList("Mario", "Mushroom", "Goomba", "Star");
        public final ObservableList<String> GRAVITY_TYPE_LIST = FXCollections.observableArrayList("Nothing", "Earth", "Super Mario", "Super Mario 2", "Super Mario 3", 
                                                                                                  "Super Mario World", "Super Mario Sunshine", "Super Paper Mario", 
                                                                                                  "Super Mario 64");
        public final ObservableList<String> LENS_TYPE_LIST = FXCollections.observableArrayList("Converging", "Diverging");
        public final ObservableList<String> MATERIAL_TYPE_LIST = FXCollections.observableArrayList("Water", "Glycerin", "Oil", "Zircon", "Diamond", "Pyrex");

	//Unit labels
        public final String UNIT_NEWTON = "N";
        public final String UNIT_KG = "kg";
        public final String UNIT_M_PER_S = "m/s";
        public final String UNIT_DEGREE = "\u00B0";
        public final String UNIT_CM = "cm";
        public final String UNIT_NM = "nm";
        public final String UNIT_DOLLAR = "$";
        
	//Math
	public final double TWO_PI = 2*Math.PI;
	public final double FULL_ROTATION = 360;
        public final String SIGMA = "\u03A3";
        public final String PI_TEXT = "\u03C0";
        
        //Cart class constants
        public final double[] Car_Polygon_X = {10, 20, 30, 50, 60, 70, 80, 10};
    	public final double[] Car_Polygon_Y = {220, 220, 210, 210, 220, 220, 240, 240};
    	public final int POLYGON_SIDE_NUM = 8;
    	public final int CAR_WHEEL_ONE_INIT_X = 20;
    	public final int CAR_WHEEL_TWO_INIT_X = 45;
    	public final int CAR_WHEEL_INIT_Y = 230;
    	public final int CAR_WHEEL_DIAMETER = 15;
        
        //thin film animation constants
            //film rectangle dimensions
        public final double MIN_FILM_HEIGHT = 5;
        public final double MAX_FILM_HEIGHT = 50;
        public final double MATERIAL_HEIGHT = 75;
            //rectangle/line drawing positions
        public final double END_POINT_X_POS = 300;
        public final double TOP_OF_MATERIAL_Y_POS = 225;
        public final double MIDDLE_OF_FILM_X_POS = 150;
            //pi/zero drawing positions
        public final double X_POS_SYMBOL_1 = END_POINT_X_POS - 30;
        public final double X_POS_SYMBOL_2 = END_POINT_X_POS - 10;
        public final double Y_POS_SYMBOL_1 = 20;
        public final double Y_POS_SHIFT_SYMBOL_2 = 30;
            
        
        //optics animation constants
            //drawing lens
        public final int LENS_MIN_HALF_LENGTH = 75;
        public final int LENS_ARROW_HEAD_LENGTH = 15;
            //drawing focal point
        public final int FOCAL_LINE_HALF_LENGH = 5;
        public final int FOCAL_LETTER_VERT_ADJ = 17;
        public final int FOCAL_LETTER_HOR_ADJ = 3;
        public final String FOCAL_LETTER_STRING = "F";
            //drawing object/image
        public final int OBJ_IMG_ARROW_HEAD_LENGTH = 5;
            //lens type
        public final String LENS_DIVERGING  = "diverging";
        public final String LENS_CONVERGING = "converging";
        
        //for new bike
            //original height and width of money pile
        public final double MONEY_PILE_MAX_WIDTH = 300;
        public final double MONEY_PILE_MAX_HEIGHT = 250;
        public final Image hoverOverPointImage = new Image("file:/" + Constants.DIR + "/src/res/hoverOverPoint.png");
        public final String salePriceString = "Sale price = ";
        public final String moneyPileImage = "file:/" + Constants.DIR + "/src/res/moneyPile.png";
        public final String unitsForSaleString = "$\nNumber of units to sell = ";
        public final String potentialProfitString = "\nPotential profit = ";
        public final String dollarSignString = "$";
        public final double intercept = 70000;
        //public final double MONEY_PILE_OG_WIDTH = 400;
        //public final double MONEY_PILE_OG_HEIGHT = 341;
        
        //For Newton's Law and Projectile motion
        public final double NANOSECOND_RATIO = (1.0)/(1000000000.0);
        public final int SPEED_RATIO = 10;
        public final int X_BOUDARY = 300;
        public final int Y_BOUNDARY = -30;
        public final int initHeight = 199;
        public final int initWidth = 21;
        public final int magicNumber = 23;
        public final int canonPos_X = 11;
        public final int canonPos_Y = 196;
        public final Image canonImage = new Image("file:/" + Constants.DIR + "/src/res/Cannon.png");
        public final Image canonStandImage = new Image("file:/" + Constants.DIR + "/src/res/CannonStand2.png");
        public final Image backImage = new Image("file:/" + Constants.DIR + "/src/res/ProjMotBack.png");
        public final Image starImage = new Image("file:/" + Constants.DIR + "/src/res/star.png");
        public final Image goombaImage = new Image("file:/" + Constants.DIR + "/src/res/Goomba.png");
        public final Image mushshroomImage = new Image("file:/" + Constants.DIR + "/src/res/mushroom.png");
        public final Image marioImage = new Image("file:/" + Constants.DIR + "/src/res/mario.png");
        public final Image newtLawBack = new Image("file:/" + Constants.DIR + "/src/res/NewtLawBack.jpg");
        
        public final Media maMiaSound = new Media(new File(Constants.DIR + "/src/res/sm64_mario_mamma-mia.wav").toURI().toString());
        public final Media starSound = new Media(new File(Constants.DIR + "/src/res/Super Mario Kart - Star Power.mp3").toURI().toString());
        public final Media goombaSound = new Media(new File(Constants.DIR + "/src/res/smb3_thwomp.wav").toURI().toString());
        public final Media mushaSound = new Media(new File(Constants.DIR + "/src/res/smb_powerup.wav").toURI().toString());
        
        //For Inf Geom Series
        public final double DEFAULT_SIDE = 10.0;
        public final long delay = 1000;

}
