import java.util.ArrayList;
import java.util.Scanner;

public class Synapse implements Receiver{
	
	int amount;
	Neuron from;
	Neuron to;
	ArrayList<Receptor> receptors=new ArrayList<Receptor>();
	
	Synapse(int amt, Neuron from, Neuron to, ArrayList<Receptor> receptors)
	{
		amount=amt;
		this.from=from;
		this.to=to;
		this.receptors=receptors;
	}
	
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
		NT_A nta=new NT_A(1000);
		Neuron sensory=new Neuron(nta,300,5000);
		Neuron motor=new Neuron(nta,0,0);
		R_A ra=new R_A(motor,10000);
		ArrayList<Receptor> receptorList=new ArrayList<Receptor>();
		receptorList.add(ra);
		Synapse btw=new Synapse(2,sensory,motor,receptorList);
		sensory.addReceiver(btw);
		Muscle muscle=new Muscle();
		motor.addReceiver(muscle);
		
		Touch A=new Touch(sensory);
		
		int input=0;
		while(true)
		{
			for(int i=0;i<10;i++)
			{
			Thread.sleep(1000);
			
			A.touch(1);
			}
			Thread.sleep(10000);

		}
	}
}
