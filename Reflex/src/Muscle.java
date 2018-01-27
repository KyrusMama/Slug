
public class Muscle implements Receiver{

	Clock timeKeep=new Clock(1000,2500);
	@Override
	public void receive() {
		// TODO Auto-generated method stub
		System.out.println(timeKeep.effect());
	}

}
