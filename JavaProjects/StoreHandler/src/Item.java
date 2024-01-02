// PROG2 VT2021, Inlämningsuppgift, del 1
// Grupp 056
// Sarah Andersson saan3355
// Malin Söderlund maso1928

public abstract class Item implements Vat {
    protected final String name;

    protected Item (String name){
        this.name = name;
    }

    public abstract double getPrice();

    public final double getPricePlusVAT (){
        return getPrice() + (getPrice() * getVAT());

    }

}

