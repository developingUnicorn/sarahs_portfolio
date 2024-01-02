// PROG2 VT2021, Inlämningsuppgift, del 1
// Grupp 056
// Sarah Andersson saan3355
// Malin Söderlund maso1928
import java.util.ArrayList;

public class Order {

    private static long counter;
    private final ArrayList<Item> items = new ArrayList<Item>();
    private final long orderNumber = 0;

    public Order (Item i1,Item i2){

        items.add(i1);
        items.add(i2);

    }
    public Order (Item i1,Item i2,Item i3){

        items.add(i1);
        items.add(i2);
        items.add(i3);
    }


    public double getTotalValue(){
        double value = 0;
        for (int i = 0; i < items.size(); i++){
            value += items.get(i).getPrice();
        }
        return value;
    }

    public double getTotalValuePlusVAT(){
        double value = 0;
        for (int i = 0; i < items.size(); i++){
            value += items.get(i).getPricePlusVAT();
        }
        return value;
    }

    public String getReceipt(){
        counter ++;
        String receipt = "Receipt for order #" + counter + "\n ----------- \n" +
                items.toString().replace("[","").replace("]","").replace("}\n,","}\n")  +
                "\n\nTotal excl. VAT: " + getTotalValue() + "\nTotal incl. Vat: " + getTotalValuePlusVAT() +
                "\n ----------- ";

        return receipt;
    }
}
