
public class Muscle implements Receiver{

	Clock timeKeep=new Clock(10,100);
	@Override
	public void receive() {
		// TODO Auto-generated method stub
		//System.out.println("muscle = "+ timeKeep.effect());
	}

	public static void main(String[] args) throws InterruptedException
	{
		Muscle A=new Muscle();
		while(true)
		
		{
			for(int i=0;i<10;i++)
		{
				Thread.sleep(100);

			A.receive();
		}
			Thread.sleep(10000);

		}
		
	}
}
