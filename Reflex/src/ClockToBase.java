public class ClockToBase {
	
	double c;
	
	double base;
	
	double amt;
	long lastTime;
	
	ClockToBase(double amt,double c)
	{
		this.amt=amt;
		this.c=c;
	}
	
	double getAmt()
	{
		long time=System.currentTimeMillis();
		return amt*Math.pow(Math.E, (-1*Math.abs(time-lastTime)/c));
	}
	
	public void set(double amt)
	{
		lastTime=System.currentTimeMillis();
		this.amt=amt;
	}
	
	
	
}
