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
<<<<<<< HEAD
		return base + amt*Math.pow(Math.E, (-1*Math.abs(time-lastTime)/c));
=======
		double x = Math.abs(time - lastTime);
		return base + Calculate.decayEffect(amt,x,c);
		
>>>>>>> b0298e4820eb2fd11af394af1fa0c23c3d5d3fc9
	}
	
	public void set(double amt)
	{
		lastTime=System.currentTimeMillis();
		this.amt=amt;
	}
	
	
	
}
