import java.util.ArrayList;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }
    
    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber); //primer objeto lot 
        if(selectedLot != null) {
            //Bid bid = new Bid(bidder, value);//2� objeto var local bid (puja)
            //podemos debido a que pasamos el objeto a metodo bit for directamente
            boolean successful = selectedLot.bidFor(new Bid(bidder, value) );//objeto anonimo tipo bid
            if(successful) {
                System.out.println("The bid for lot number " +
                                   lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                //Bid highestBid = selectedLot.getHighestBid(); //3� objeto highestbid --mayor puja
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                          selectedLot.getHighestBid().getValue());//solo usamos el 3� objeto aqui
            }
        }
    }

    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber)
    {
        if((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            // The number seems to be reasonable.
            Lot selectedLot = lots.get(lotNumber - 1);
            // Include a confidence check to be sure we have the
            // right lot.
            if(selectedLot.getNumber() != lotNumber) {
                System.out.println("Internal error: Lot number " +
                                   selectedLot.getNumber() +
                                   " was returned instead of " +
                                   lotNumber);
                // Don't return an invalid lot.
                selectedLot = null;
            }
            return selectedLot;
        }
        else {
            System.out.println("Lot number: " + lotNumber +
                               " does not exist.");
            return null;
        }
    }
    
    /**
     * a�ade un m�todo denominado close a la clase Auction.
     * Debe mostrar los detalles de todos los items que se est�n subastando. 
     * De aquellos por los que haya habido pujas se debe indicar el nombre de la
     * persona que ha hecho la puja m�s alta y el valor de dicha puja; del resto 
     * debe indicar que no ha habido pujas.
     */
    public void close()
    {
     
        for( Lot objeto : lots)
        {
            System.out.println("detalles" + objeto.toString());
            
            if (objeto.getHighestBid() != null)
            {
                System.out.println(objeto.getHighestBid().getBidder().getName());
            }
            
        }
        
    }
    
    /**
     * m�todo denominado getUnsold a la clase Auction que devuelva una colecci�n
     * de todos los items por los que no habido ninguna puja en este momento y no imprima nada por pantalla.
     */
    public ArrayList getUnsold()
    {
        
        ArrayList<Lot> lotes = new ArrayList<Lot>();
        
        
        for (Lot objeto : lots)
        {
           if(objeto.getHighestBid() ==  null)
           {
              lotes.add(objeto);
             
           }
            
        }
        return lotes;
    }
}
