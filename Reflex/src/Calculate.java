import java.util.*;
public class Calculate {

	/**
	 * Represents the function y = total * e^(-x/c)
	 * @param total	
	 * @param x
	 * @param c
	 * @return y
	 */
	public static double decayEffect(double total, double x, double c) 
	{
		double effect = total*Math.pow(Math.E, (-x/c));
		return effect;
	}

	/**
	 * Represents the function y = total * (1 - e^(-x/c))
	 * @param total
	 * @param x
	 * @param c
	 * @return y
	 */
	public static double growthEffect(double total, double x, double c)
	{
		double effect = total*(1-(Math.pow(Math.E, (-x/c))));
		return effect;
	}

}