import java.util.ArrayList;
import java.util.Scanner;

public class Synapse implements Receiver{
	
	int amount;	//the number of synapses between the neuron pair
	Neuron from;		//the neuron from which the signal is coming
	Neuron to;	//the neuron to be affected by the signal
	ArrayList<Receptor> receptors=new ArrayList<Receptor>();	//a list of receptors on the postsynaptic neuron
	
	/**
	 * 
	 * @param amt the number of synapses between the neuron pair
	 * @param from the neuron from which the signal is coming
	 * @param to the neuron to be affected by the signal
	 * @param receptors a list of receptors on the postsynaptic neuron
	 */
	Synapse(int amt, Neuron from, Neuron to, ArrayList<Receptor> receptors)
	{
		amount=amt;
		this.from=from;
		//if(!this.from.next.contains(this))
		//	this.from.addReceiver(this);
		this.to=to;
		this.receptors=receptors;
	}
	
	/**
	 * 
	 * @param amt the number of synapses between the neuron pair
	 * @param from the neuron from which the signal is coming
	 * @param to the neuron to be affected by the signal
	 */
	Synapse(int amt, Neuron from, Neuron to)
	{
		amount=amt;
		this.from=from;
		//if(!this.from.next.contains(this))
		//	this.from.addReceiver(this);
		this.to=to;
	}
	
	/**
	 * Adds a receptor to the list of receptors in this synapse
	 * @param a receptor to be added
	 */
	public void addReceptor(Receptor a)
	{
		receptors.add(a);
	}
	
	/**
	 * recieves a signal and applies it to all the receptors on the ending of the neuron
	 * by calling receptor.tansmit()
	 * does this for each of the numbers of synapses
	 * After if finishes, tells the postsynaptic neuron to check if it should fire
	 */
	public void receive()
	{
		Neurotransmitter NT=from.NT;
		for(int j=0;j<amount;j++)
		{
			for(Receptor i:receptors)
			{
				i.transmit(NT);
			}
		}
		to.checkFire();
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		Scanner in=new Scanner(System.in);
		NT_A nta=new NT_A(100);	
		Neuron sensory=new Neuron(nta,50,10000,"sensory");	
		Neuron motor=new Neuron(nta,0,0,"motor");
		R_A ra=new R_A(motor,1000,100);
		ArrayList<Receptor> receptorList=new ArrayList<Receptor>();
		receptorList.add(ra);
		Synapse btw=new Synapse(100,sensory,motor,receptorList);
		sensory.addReceiver(btw);
		Muscle muscle=new Muscle();
		motor.addReceiver(muscle);
		
		Touch A=new Touch(sensory);
		
		int input=0;
		int count=0;
		while(true)
		{
			for(int i=0;i<10;i++)
			{
			//Thread.sleep((long) (10*Math.random()* 1000)); 
				Thread.sleep(3000);
			System.out.println("IN A FIRE "+ (++count));
			A.touch(1);
			}

			Thread.sleep(10000);
			

		}
	}
}
