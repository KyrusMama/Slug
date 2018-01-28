public class R_A extends IonotropicReceptor{

	double c;
	
	/**
	 * 
	 * @param belong the neuron this recepter belongs to
	 * @param amount the maximum amount of effect that can be caused by an infinite amount of neurotransmitter
	 * directly proportional to the number of receptors
	 * @param c variable to be used in growth curve to measure nt-receptor interaction
	 */
    R_A(Neuron belong, double amount, double c) {
		super(belong, amount);
		this.c=c;
	}

    /**
     * Takes in a Neurotransmitter and deals with it
     * In this case if is of NT_A 
     * increases the potential which the 
     */
    @Override
    public void transmit(Neurotransmitter nt) {
    		if(nt instanceof NT_A)
        {
            belong.setPotential(belong.getPotential() + Calculate.growthEffect(amount,nt.amount,c));
        }
    }
    
}
