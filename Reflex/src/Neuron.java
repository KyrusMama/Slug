import java.util.*;
public class Neuron {
	
	public Neurotransmitter NT;
	
	ArrayList<Receiver> next=new ArrayList<Receiver>();
	
	double potential;
	
	double base;
	double threshold;
	
	ClockToBase PotentialSet=new ClockToBase(base,1000.0);
	
	Clock NTeffector=new Clock(1000,1000);
	
	public static void main(String[] args) 
	{
		System.out.println();

		ClockToBase A=new ClockToBase(0,2500);
		Scanner in=new Scanner(System.in);
		double a,b;
		while(true) {
			a=in.nextDouble();
			b=A.getAmt();
			System.out.println(b);
			a+=b;
			A.set(a);
		}
		
	}
	
}
