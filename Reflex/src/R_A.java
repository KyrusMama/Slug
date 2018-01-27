public class R_A extends IonotropicReceptor{
    double potIncrease = 10;// growth curve
    @Override
    public void transmit(Neurotransmitter nt) {
        // TODO Auto-generated method stub
        if(nt instanceof NT_A)
        {
            belong.potential += potIncrease;
        }
    }
    
}
