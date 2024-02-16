

public class LongPlay extends Recording {

    private int currentYear = 2021;

    public LongPlay (String name, String artist, int year, int condition, double price){

        super(name, artist,year,condition,price,"LP");

    }

    @Override
    public double getPrice() {
        double x = price * condition/10 + (currentYear - year) * 5;
        if ( x < 10){
            return 10;
        }
        else {
            return x;
        }
    }
}
