
public abstract class Neurotransmitter {
	protected double amount;
	protected String name;
	
	/**
	 * returns the name of theneurotransmitter
	 * @return name
	 */
	public abstract String getName();
	
	/**
	 * returns amount of neurotransmiiter
	 * @return amount 
	 */
	public abstract double getAmount();
	/**
	 * sets amount to the param
	 * @param amt sets amount to amt
	 */
	public abstract void setAmount(double amt);
}
