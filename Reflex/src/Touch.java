
public class Touch {
	Neuron to;
	
	Touch(Neuron to)
	{
		this.to=to;
	}
	
	public void touch(int amt)
	{
		for(int i=0;i<amt;i++)
			to.fire();
	}
}
