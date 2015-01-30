package Main;

public class FormulaHelper 
{
	//Newtonm's Second Law
	
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
	
	//
}
