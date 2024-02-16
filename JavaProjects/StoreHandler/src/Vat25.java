
public interface Vat25 extends Vat{

    @Override
    public default double getVAT(){
        return 0.25;
    }
}
