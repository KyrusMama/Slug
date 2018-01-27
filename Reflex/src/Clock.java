import java.util.*;

public class Clock {
	
	double a;
	double c;
	
	LinkedList<Long> history=new LinkedList<Long>();
	
	Clock(double a,double c)
	{
		this.a=a;
		this.c=c;
	}
	
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
	
}
