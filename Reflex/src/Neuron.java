import java.util.*;
public class Neuron {
	
	public Neurotransmitter NT;
	double NTbaseAmount;
	
	ArrayList<Receiver> next=new ArrayList<Receiver>();
	
	double base=0;
	double threshold=100;
	//the potential is accessed through clock to base
	ClockToBase PotentialSet=new ClockToBase(base,1000.0);
	
	double a,b;

	Clock NTeffector;
	
	Neuron(Neurotransmitter NT,double a, double b)
	{
		this.NT=NT;
		NTbaseAmount=NT.amount;
		this.a=a;
		this.b=b;
		NTeffector=new Clock(a,b);
	}
	
	Neuron(Neurotransmitter NT)
	{
		this.NT=NT;
		NTbaseAmount=NT.amount;
		NTeffector=new Clock(100,100);

	}
	
	void addReceiver(Receiver tba)
	{
		next.add(tba);
	}
	
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
			setPotential(pot-(threshold));
			System.out.println("motor fire");

			fire();
			checkFire();		//recursive
			return true;
		}
		return false;
	}
	
	public void fire()
	{
		double eff;
		NT.amount = NTbaseAmount-(eff=NTeffector.effect());
		System.out.println(eff);
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
