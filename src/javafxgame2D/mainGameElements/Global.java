

package javafxgame2D.mainGameElements;

/**
 *
 * @author Ahmad El-Baher
 */
public class Global 
{
    public static boolean isFloatEquality(float fNum_1, float fNum_2)
    {
        return Math.abs(fNum_1 - fNum_2) < Constants.EPSILON;
    }
    
    public static boolean isDoubleEquality(double dNum_1, double dNum_2)
    {
        return Math.abs(dNum_1 - dNum_2) < Constants.EPSILON;
    }
    
    public static String getStringTrimmedNoSpaces(String strValue)
    {
        return strValue.trim().replaceAll(Constants.REGEX_SPACE, Constants.REGEX_EMPTY);
    }

    public static interface Constants
    {
            //This is for comparing doubles/floats for equality
        public final double EPSILON = 0.00001;
            //Regex's for replacing space characters in strings with an empty string (removing spaces from a string)
        public static final String REGEX_SPACE = "\\s+";
        public static final String REGEX_EMPTY = "";
            //Regex for a single digit from 0 to 9
        public static final String REGEX_ONE_DIG = "[0-9]";
    }
}
