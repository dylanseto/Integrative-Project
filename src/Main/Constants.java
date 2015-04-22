package Main;

import java.text.DecimalFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface Constants
{
        //general
	public final int ZERO = 0;
	public final int ONE = 1;
        public final int TWO = 2;
        public final int THREE = 3;
        public final int ONE_HUNDRED = 100;
        public final int TWO_HUNDRED = 200;
	public final double ONE_HALF = 0.5;
        public final String EMPTY_STRING = "";
        public final int MAX_RGB_VALUE = 255;
        public final String DIR = System.getProperty("user.dir");
        public final DecimalFormat FORMATTER = new DecimalFormat("#0.00");

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
	public final double METER_RATIO = 0.001;
	public final double SCREEN_SPLIT_RATIO = 0.5;

	//Combo Box options
	public final String OPTION_MECHANICS = "Mechanics";
	public final String OPTION_WAVES = "Waves";
	public final String OPTION_CALCULUS = "Calculus";
	public final String OPTION_EXIT = "Exit";
        
        //Button options
        public final String OPTION_NEWTON = "Newton's Second Law";
        public final String OPTION_PROJ_MOT = "Projectile Motion";
        public final String OPTION_OPTICS = "Optics";
        public final String OPTION_THIN_FILM = "Thin Film";
        public final String OPTION_NEW_BIKE = "New Sports Bike";
        public final String OPTION_INF_GEOM = "Infinite Geometric Series";
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
        public final String NEWTON_HELP_MSG = "";
        public final String PROJ_MOT_HELP_MSG = "";
        public final String OPTICS_HELP_MSG = "";
        public final String THIN_FILM_HELP_MSG = "";
        public final String NEW_BIKE_HELP_MSG = "";
        public final String INF_GEOM_HELP_MSG = "";
        
        //GUISection label texts
        public final String ENTER_VAL_LABEL_TEXT = "Enter Values";
        public final String FORCE_LABEL_TEXT = "Force = ";
        public final String MASS_LABEL_TEXT = "Mass = ";
        public final String INIT_VEL_LABEL_TEXT = "Initial velocity = ";
        public final String OBJECT_LABEL_TEXT = "Object:";
        public final String GRAVITY_LABEL_TEXT = "Gravity = ";
        public final String ANGLE_LABEL_TEXT = "Angle = ";
        public final String IMAGE_LABEL_TEXT = "Image";
        public final String IMG_DIST_LABEL_TEXT = "Distance";
        public final String IMG_HEIGHT_LABEL_TEXT = "Height";
        public final String MAGNIFICATION_LABEL_TEXT = "Magnification";
        public final String REAL_OR_VIRT_LABEL_TEXT = "Real or Virtual?";
        public final String REAL_LABEL_TEXT = "Real";
        public final String VIRTUAL_LABEL_TEXT = "Virtual";
        public final String LENS_LABEL_TEXT = "Lens type:";
        public final String OBJ_HEIGHT_LABEL_TEXT = "Object height = ";
        public final String OBJ_DIST_LABEL_TEXT = "Object distance = ";
        public final String FOCAL_DIST_LABEL_TEXT = "Focal distance = ";
        public final String WAVE_LENGTHS_LABEL_TEXT = "Wavelengths Within Visible Light Range (400nm - 700nm)";
        public final String ENHANCED_LABEL_TEXT = "Enhanced";
        public final String DESTROYED_LABEL_TEXT = "Destroyed";
        public final String MATERIAL_LABEL_TEXT = "Material:";
        public final String INDEX_REF_MAT_LABEL_TEXT = "nm = ";
        public final String THICKNESS_LABEL_TEXT = "Thickness = ";
        public final String COST_SET_UP_LABEL_TEXT = "Manufacturing costs = ";
        public final String COEFF_LABEL_TEXT = "a = ";
        public final String BASE_LABEL_TEXT = "r = ";
        public final String EXPONENT_LABEL_TEXT = "k = ";
        
        //Graph labels
        public final int GRAPH_TITLE_INDEX = 0;
        public final int GRAPH_Y_AXIS_INDEX = 1;
        public final int GRAPH_X_AXIS_INDEX = 2;
        public final String[] NEWTON_GRAPH_LABELS = {"Velocity vs. Time", "Velocity (m/s)", "Time (s)"};
        public final String[] PROJ_MOT_GRAPH_LABELS = {"Vertical Displacement vs. Time", "Vertical Displacement (m)", "Time (s)"};
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
    	public final double[] Car_Polygon_Y = {140, 140, 130, 130, 140, 140, 160, 160};;
    	public final int POLYGON_SIDE_NUM = 8;
    	public final int CAR_WHEEL_ONE_INIT_X = 20;
    	public final int CAR_WHEEL_TWO_INIT_X = 45;
    	public final int CAR_WHEEL_INIT_Y = 150;
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
        //public final double MONEY_PILE_OG_WIDTH = 400;
        //public final double MONEY_PILE_OG_HEIGHT = 341;

}
