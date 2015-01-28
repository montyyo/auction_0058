
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    public void test1()
    {
        Auction objeto = new Auction();
        
        objeto.enterLot("1");
        objeto.enterLot("2");
        objeto.enterLot("3");
        objeto.enterLot("4");
        objeto.enterLot("5");
        
        Person postor = new Person("Pedro");
       
        //objeto.makeABid(int lotNumber, Person bidder, long value)
        //objeto.makeABid(1, "Pedro", 12);
        
        objeto.close();
    }
}
