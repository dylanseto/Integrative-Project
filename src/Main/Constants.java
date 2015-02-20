package Main;

public interface Constants
{
	public final int ZERO = 0;
	public final int ONE = 1;
        public final int TWO = 2;
	public final double ONE_HALF = 0.5;
        public final String EMPTY_STRING = "";

	//Index of Refraction
	public final double INDEX_REF_AIR = 1.0003;
	public final double INDEX_REF_WATER = 1.333;
	public final double INDEX_REF_GLYCERIN = 1.473;
	public final double INDEX_REF_OIL = 1.515;
	public final double INDEX_REF_ZIRCON = 1.920;
	public final double INDEX_REF_DIAMOND = 2.417;
	public final double INDEX_REF_PYREX = 1.470;

	//Sizing ratios
	public final double METER_RATIO = 1/1000;
	public final double SCREEN_SPLIT_RATIO = 1/2;

	//Combo Box options
	public final String OPTION_MECHANICS = "Mechanics";
	public final String OPTION_WAVES = "Waves";
	public final String OPTION_CALCULUS = "Calculus";
	public final String OPTION_EXIT = "Exit";
        
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
	
	//Math
	public final double TWO_PI = 2*Math.PI;
	public final double FULL_ROTATION = 360;
}
