import java.util.Scanner;

public class Neuron {
	
	public static void main(String[] args) 
	{
		System.out.println();

		Clock A=new Clock(1000,10000);
		Scanner in=new Scanner(System.in);
		while(in.next().equals("a"))
			System.out.println(A.effect());
		
	}
	
}
