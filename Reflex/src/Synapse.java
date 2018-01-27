import java.util.ArrayList;

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
		
	}
	
}
