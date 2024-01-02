// PROG2 VT2021, Inlämningsuppgift, del 1
// Grupp 056
// Sarah Andersson saan3355
// Malin Söderlund maso1928

public interface Vat6 extends Vat{

    @Override
    public default double getVAT(){
        return 0.06;
    }
}
