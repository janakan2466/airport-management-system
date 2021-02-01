/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528lab1;

/**
 *
 * @author janakansivaloganathan
 */
public class Ticket {
    Passenger passenger;
    Flight flight;
    double price;
    static int number= 0;
/**
 *Ticket constructor
 * @param p
 * @param flight
 * @param price
 */
    public Ticket(Passenger p, Flight flight, double price){
        this.passenger = p;
        this.flight = flight;
        this.price = price;
        number++;
    }
/**
 *Ticket constructor
 * @return Overridden String of ticket
 */
    //although a ticket number is created for each ticket, the number is not included in the overrriden toString
    @Override
    public String toString(){
        return this.passenger.name +", Flight " +this.flight.getflightNumber() 
               +", " +this.flight.getorigin() +" to " +this.flight.getdestination() 
               +", " +this.flight.getdepartureTime() +", original price: $" 
               +this.flight.getoriginalPrice() +", ticket price: " +this.price;
    }
 /**
 *getPassenger
 * @return passenger
 */   
    public Passenger getPassenger() {
        return passenger;
    }
 /**
 *setPassenger
 * @param passenger
 */   
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
 /**
 *getFlight
 * @return flight
 */   
    public Flight getFlight() {
        return flight;
    }
 /**
 *setFlight
 * @param flight
 */   
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
 /**
 *getPrice
 * @return price
 */   
    public double getPrice() {
        return price;
    }
 /**
 *setPrice
 * @param price
 */   
    public void setPrice(double price) {
        this.price = price;
    }
 /**
 *getNumber
 * @return number
 */   
    public static int getNumber() {
        return number;
    }
 /**
 *setNumber
 * @param numbTickets
 */   
    public static void setNumber(int numbTickets) {
        number = numbTickets;
    }
    
    
}
