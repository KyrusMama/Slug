public class R_A extends IonotropicReceptor{

    R_A(Neuron belong, double amount) {
		super(belong, amount);
	}

    @Override
    public void transmit(Neurotransmitter nt) {
        // TODO Auto-generated method stub
        if(nt instanceof NT_A)
        {
            belong.setPotential(belong.getPotential() + Calculate.growthEffect(amount,nt.amount,1));
        }
    }
    
}
