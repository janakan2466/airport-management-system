package coe528lab1;

/**
 *
 * @author janakansivaloganathan
 */
public class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
 /**
 *Flight constructor
 * @param flightNumber
 * @param origin
 * @param destination
 * @param departureTime
 * @param capacity
 * @param originalPrice
 * @throws IllegalArgumentException
 */   
    /*Implemented 2 additional Exceptions if the capacity is less than 75 for a flight or the original price is less than 200; this allows
      a more realistic environment for the plane ticket booking system. */
    public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, int originalPrice){
        this.flightNumber= flightNumber;
        this.origin= origin;
        this.destination= destination;
        this.departureTime= departureTime;
        this.capacity= capacity;
        this.originalPrice= originalPrice;
        this.numberOfSeatsLeft= capacity;
        
        //try{
        //    if(this.capacity < 75){
        //        throw new IllegalArgumentException("Error: the specified plane capacity must be greater than 75!");
        //    }
            
        //    if(this.originalPrice < 200.0){
        //        throw new IllegalArgumentException("Error: the specified original price is far below the base price for this system!");
        //    }
           
            if(this.destination.equalsIgnoreCase(this.origin)){
                throw new IllegalArgumentException("Error: the specified origin and destination cannot be the same!");
            }
        //}
        //catch(IllegalArgumentException e){
        //              System.out.println("Sorry you have encountered an error. Either you capacity for the plane was below 75, "
        //              + "the base price was below $200, or your origin and desination was the same.");
        //}
    }
/**
 *bookASeat
 * @return true
 */            
    public boolean bookASeat(){
        if (numberOfSeatsLeft > 0){
            numberOfSeatsLeft--;
            return true;
        }
        else 
            return false;
    }
/**
 *toString
 * @return String of flight information
 */    
    @Override
    public String toString(){
            return "Flight " +flightNumber + ", " +origin + " to " +destination + ", " +departureTime + ", original price: $" +originalPrice;
    } 
/**
 *getflightNumber
 * @return this.flightNumber
 */    
    public int getflightNumber(){
        return this.flightNumber;
    }
/**
 *setflightNumber
 * @param flightNumber
 */    
    public void setflightNumber(int flightNumber){
        this.flightNumber= flightNumber;
    }
/**
 *getOrigin
 * @return this.origin
 */    
    public String getorigin(){
        return this.origin;
    }
/**
 *setOrigin
 * @param origin
 */    
    public void setorigin(String origin){
        this.origin= origin;
    }
/**
 *getDestination
 * @return this.destination
 */    
    public String getdestination(){
        return this.destination;
    }
/**
 *setDestination
 * @param destination
 */    
    public void setdestination(String destination){
        this.destination= destination;
    }
/**
 *getdepartureTime
 * @return this.departureTime
 */    
    public String getdepartureTime(){
        return this.departureTime;
    }
/**
 *setdepartureTime
 * @param departureTime
 */    
    public void setdepartureTime(String departureTime){
        this.departureTime= departureTime;
    }
/**
 *getCapacity
 * @return capacity
 */    
    public int getcapacity(){
        return capacity;
    }
/**
 *setCapacity
 * @param capacity
 */    
    public void setcapacity(int capacity){
        this.capacity= capacity;
    }
/**
 *getnumberOfSeatsLeft
 * @return numberOfSeatsLeft
 */    
    public int getnumberOfSeatsLeft(){
        return numberOfSeatsLeft;
    }
/**
 *setnumberOfSeatsLeft
 * @param remainingSeats
 */    
    public void setnumberOfSeatsLeft(int remainingSeats){
        numberOfSeatsLeft= remainingSeats; 
    }
/**
 *getOriginalprice
 * @return this.originalPrice
 */    
    public double getoriginalPrice(){
        return this.originalPrice;
    }
/**
 *setoriginalPrice
 * @param originalPrice
 */    
    public void setoriginalPrice(double originalPrice){
        this.originalPrice= originalPrice;
    }
    
}
