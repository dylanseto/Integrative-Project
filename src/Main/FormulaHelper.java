package Main;

public class FormulaHelper 
{
	//Newton's Second Law
	
	public static double computeAccel(double force, double mass)
	{
		return (force/mass);
	}
	
	public static double computeVelocity(double deltaTime, double acceleration, double prevVelocity)
	{
		return ((deltaTime*acceleration)+prevVelocity);
	}
	
	public static double computeDisplacement(double deltaTime, double curVelocty, double prevDisplacement)
	{
		return ((deltaTime*curVelocty)+prevDisplacement);
	}
	
	//Projectile motion
	public static double computeCurrentHeight(double deltaTime, double curVelocty_y, double prevHeight, double gravity)
	{
		return ((curVelocty_y*deltaTime)+(Constants.ONE_HALF*gravity*Math.pow(deltaTime, 2)) + prevHeight);
	}
	
	public static double getVertVel(double angleDegrees, double initVel)
	{
		return (initVel * Math.sin(toRadians(angleDegrees)));
	}
	public static double getHorVel(double angleDegrees, double initVel)
	{
		return (initVel * Math.cos(toRadians(angleDegrees)));
	}
	//Optics
	
	//mainformula
	public static double computeImageDistance(double focalPoint, double objectDistance)
	{
		return (Constants.ONE/((Constants.ONE/focalPoint)+(Constants.ONE/objectDistance)));
	}
	
	public static double computeImageHeight(double objectHeight, double imagedistance, double objectDistance)
	{
		return ((imagedistance/objectDistance)*objectHeight);
	}
	private static double toRadians(double angleInDegrees)
	{
		return (angleInDegrees*Constants.TWO_PI)/Constants.FULL_ROTATION;
	}
}
