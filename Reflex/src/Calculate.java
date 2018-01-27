import java.util.*;
public class Calculate {

	public static double decayEffect(double total, double x, double c) 
	{
		double effect = total*Math.pow(Math.E, (-x/c));
		return effect;
	}

	public static double growthEffect(double total, double x, double c)
	{
		double effect = total*(1-(Math.pow(Math.E, (-x/c))));
		return effect;
	}
/*	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("h");
		double 
	}*/
}