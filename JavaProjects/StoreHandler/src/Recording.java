// PROG2 VT2021, Inlämningsuppgift, del 1
// Grupp 056
// Sarah Andersson saan3355
// Malin Söderlund maso1928

public abstract class Recording extends Item implements Vat25{ //extends Item

    protected final String artist;
    protected final int year;
    protected int condition;
    protected final double price;
    private final String type;

    public Recording (String name, String artist, int year, int condition, double price, String type){
        super(name);
        this.artist = artist;
        this.year = year;
        this.condition = condition;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "* Recording{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                ", condition=" + condition +
                ", original price=" + price +
                ", price=" + getPrice() +
                ", price+vat= " + getPricePlusVAT() +
                ", type='" + type + '\'' +
                '}' + '\n';
    }



}
