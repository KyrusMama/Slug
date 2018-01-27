public class R_A extends IonotropicReceptor{
<<<<<<< HEAD
=======
    double potIncrease = 10;// growth curve
>>>>>>> b0298e4820eb2fd11af394af1fa0c23c3d5d3fc9
    @Override
    public void transmit(Neurotransmitter nt) {
        // TODO Auto-generated method stub
        if(nt instanceof NT_A)
        {
            belong.setPotential(belong.getPotential() + Calculate.growthEffect(amount,nt.amount,1));
        }
    }
    
}
