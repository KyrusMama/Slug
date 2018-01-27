
public abstract class Receptor {
	Neuron belong;
	double amount;
	public abstract void transmit(Neurotransmitter A);
	Receptor(Neuron belong,double amount)
	{
		this.belong=belong;
		this.amount=amount;
	}
}
