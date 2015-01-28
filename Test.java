
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
        
        Person person1 = new Person("Pedro");
        Person person2 = new Person("juan");
        objeto.makeABid(1, person1, 12);
        objeto.makeABid(2, person1, 12);
        objeto.makeABid(2, person2, 16);
        //objeto.makeABid(int lotNumber, Person bidder, long value)
        //objeto.makeABid(1, "Pedro", 12);
        
        objeto.close();
        objeto.getUnsold();
    }
}
