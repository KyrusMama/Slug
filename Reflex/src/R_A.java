public class R_A extends IonotropicReceptor{

    @Override
    public void transmit(Neurotransmitter nt) {
        // TODO Auto-generated method stub
        if(nt instanceof NT_A)
        {
            belong.setPotential(belong.getPotential() + Calculate.growthEffect(amount,nt.amount,1));
        }
    }
    
}
