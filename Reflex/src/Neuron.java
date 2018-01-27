import java.util.*;
public class Neuron {
	
	public Neurotransmitter NT;
	
	ArrayList<Receiver> next=new ArrayList<Receiver>();
	
	double base=0;
	double threshold;
	//the potential is accessed through clock to base
	ClockToBase PotentialSet=new ClockToBase(base,1000.0);
	
	Clock NTeffector=new Clock(1000,1000);
	
	/**
	 * @return the potential
	 */
	public double getPotential() {
		return PotentialSet.getAmt();
	}

	/**
	 * @param potential the potential to set
	 */
	public void setPotential(double potential) {
		PotentialSet.set(potential);
	}
	
	public boolean checkFire()
	{
		double pot=getPotential();
		if(pot>threshold)
		{
			setPotential(pot-(threshold-base));
			fire();
			checkFire();		//recursive
			return true;
		}
		return false;
	}
	
	private void fire()
	{
		
	}
	
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
