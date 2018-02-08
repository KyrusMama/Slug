import java.util.*;
public class Neuron {
	
	String name;		//the name of the neuron
	
	public Neurotransmitter NT;	//The neurotransmitter contained in the neuron
	double NTbaseAmount;	//the amount of neurotransmitter that an isolated neuron would have
	
	ArrayList<Receiver> next=new ArrayList<Receiver>();
	
	double base=0;	//the resting potential
	double threshold=100;	//the potential above which the neuron will fire
	
	//the potential is accessed through clock to base
	ClockToBase PotentialSet=new ClockToBase(base,1000.0);
	
	double a,b;

	//the NT.amount is controlled through Clock in fire()
	Clock NTeffector;
	
	/**
	 * name="Neuron"
	 * contains the function NT amt = a * e^(-x/b) in Clock

	 * @param NT neurotransmitter this neuron uses
	 * @param a variable to be used to calculate NT amt
	 * @param b variable to be used to calculate NT amt
	 * 
	 */
	Neuron(Neurotransmitter NT,double a, double b)
	{
		this.NT=NT;
		NTbaseAmount=NT.amount;
		this.a=a;
		this.b=b;
		NTeffector=new Clock(a,b);
		name="Neuron";
	}
	
	/**
	 * contains the function NT amt = a * e^(-x/b) in Clock

	 * @param NT neurotransmitter this neuron uses
	 * @param a variable to be used to calculate NT amt
	 * @param b variable to be used to calculate NT amt
	 * @param name stored into Neuron.name
	 */
	Neuron(Neurotransmitter NT,double a, double b, String name)
	{
		this.NT=NT;
		NTbaseAmount=NT.amount;
		this.a=a;
		this.b=b;
		NTeffector=new Clock(a,b);
		this.name=name;
	}
	
	/**
	 * contains the function NT amt = a * e^(-x/b) in Clock
	 *
	 * a=50
	 * c=10000
	 * 
	 * name="Neuron"
	 * 
	 * @param NT neurotransmitter this neuron uses
	 */
	Neuron(Neurotransmitter NT)
	{
		this.NT=NT;
		NTbaseAmount=NT.amount;
		NTeffector=new Clock(50,10000);
		name="Neuron";
	}
	
	/**
	 * Adds a Receiver to the end of next.
	 * @param tba, the receiver to be added
	 */
	void addReceiver(Receiver tba)
	{
		next.add(tba);
	}
	
	/**
	 * @return the potential based on change from ClockToBase
	 */
	public double getPotential() {
		return PotentialSet.getAmt();
	}

	/**
	 * @param potential the potential to set into ClockToBase for this Neuron
	 */
	public void setPotential(double potential) {
		PotentialSet.set(potential);
	}
	
	/**
	 * Checks if the potential of a neuron is high enough for it to fire
	 * if yes, decreases the potential by threshold in ClockToBase 
	 * calls fire()
	 * and then checks if it should fire again
	 * 
	 *
	 */
	public void checkFire()
	{
		boolean recheck = true;
		int count=0;
		while(recheck)
		{
			double pot=getPotential();
			if(pot>threshold)
			{
				setPotential(pot-(threshold));
			
				//System.out.println(name+" fire");
				count++;
				fire();
			}
			else
				recheck=false;
		}
		System.out.println(name+" fired "+count+" times");
	}
	
	/**
	 * checks how much neurotransmitter is supposed to be used and sends that correct neurotransmitter
	 * to a the Receivers in next
	 * Invariant NT.amount>=0
	 */
	public void fire()
	{
		double eff=0;
		NT.amount = NTbaseAmount-(eff=NTeffector.effect());
		if(NT.amount<0)
			NT.amount=0;
		if(!name.equals("motor"))
		System.out.println(name + " NTamt("+ NT.amount +") = base("+NTbaseAmount+") - Clockeffect("+eff+")");
		//System.out.println(NT.amount);
		for(Receiver i:next)
			i.receive();
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
