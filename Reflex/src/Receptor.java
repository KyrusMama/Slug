
public abstract class Receptor {
	Neuron belong;
	
	/**the maximum amount of effect that can be caused by an infinite amount of neurotransmitter
	 * directly proportional to the number of receptors*/
	double amount;	
					
	/**
	 * 
	 * @param A The Neurotransmitter that is attaching to the Receptor
	 */
	public abstract void transmit(Neurotransmitter A);
	
	Receptor(Neuron belong,double amount)
	{
		this.belong=belong;
		this.amount=amount;
	}
}
