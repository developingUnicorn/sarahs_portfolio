// PROG2 VT2021, Inlämningsuppgift, del 1
// Grupp 056
// Sarah Andersson saan3355
// Malin Söderlund maso1928

public class Book extends Item implements Vat6{

    private static final double BOUNDED = 1.25;
    private final String author;
    private final double price;
    private final boolean bound;


    public Book (String name, String author, double price, boolean bound){

        super(name);
        this.author = author;
        this.price = price;
        this.bound = bound;
    }

    public double getPrice(){

        if (bound){
            return price * BOUNDED;
        }
        else{
            return price;
        }
    }
    @Override
    public String toString() {
        return "* Book {" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", bound=" + bound +
                ", price=" + getPrice() +
                ", price+vat= " + getPricePlusVAT() +
                '}' + '\n' ;
    }
}
