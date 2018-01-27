public class ClockToBase {
	
	private double c;
	
	private double base=0;
	
	private double amt;
	private long lastTime;
	
	ClockToBase(double amt,double c)
	{
		this.amt=amt;
		this.c=c;
	}
	
	double getAmt()
	{
		long time=System.currentTimeMillis();

		double x = Math.abs(time - lastTime);
		return base + Calculate.decayEffect(amt,x,c);
		
	}
	
	public void set(double amt)
	{
		lastTime=System.currentTimeMillis();
		this.amt=amt;
	}
	
	
	
}
