

public interface Vat6 extends Vat{

    @Override
    public default double getVAT(){
        return 0.06;
    }
}
