


public class TestClass {


    public static void main (String[] args){
        
        Item book = new Book("julashästar", "Jula",500,false );
        Item cd = new CompactDisc("Sarahsmelodier","Sarah", 1,5,100);
        Item lp = new LongPlay("Lislåtar","Li",1995,5,100);



        Order order = new Order(book, cd, lp);


        System.out.println(order.getReceipt());
    }


}
