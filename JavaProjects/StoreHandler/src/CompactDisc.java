

public class CompactDisc extends Recording {

    public CompactDisc (String name, String artist, int year, int condition, double price){

        super(name, artist, year, condition, price, "CD");
    }

    @Override
    public double getPrice(){

        double x = price * condition/10;
        if ( x < 10){
            return 10;
        }
        else {
            return x;
        }


    }

}
