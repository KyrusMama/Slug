import java.util.*;

public class Clock {
	
	//Uses function Calculate.decayEffect
	double a;	
	double c;
	
	//a list of all the times that the neuron has fired from CurrentTimeMillis, 
	//removes irrelevant data
	LinkedList<Long> history=new LinkedList<Long>();
	
	Clock(double a,double c)
	{
		this.a=a;
		this.c=c;
	}
	
	/**
	 * 
	 * @return
	 */
	public double effect()
	{
		int tbr=0;
		long time=System.currentTimeMillis();
		double total=0;
		for(Long i:history)
		{   
			double x= Math.abs(time-i);
			double y = Calculate.decayEffect(a, x, c);
			
			if(y<0.01*a)
			{
				//history.remove();
				tbr++;
			}
			else
			{
				total+=y;
			}
		}
		history.add(time);
		for(int x=0;x<tbr;x++)
			history.removeFirst();
		return total;
	}
	
	public void add(long time)
	{
		history.add(time);
	}
	
	public void add()
	{
		long time=System.currentTimeMillis();
		history.add(time);
	}
	
}
