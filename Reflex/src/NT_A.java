
public class NT_A extends Neurotransmitter{

	/**
	 * constructs with name "A"
	 * amount = 0
	 */
	NT_A()
	{
		name="A";
		amount=0;
	}
	
	/**
	 * name="A"
	 * @param amount stord in neurotransmitter.amt
	 */
	NT_A(double amount)
	{
		name="A";
		this.amount=amount;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public void setAmount(double amt) {
		amount=amt;
	}

}
