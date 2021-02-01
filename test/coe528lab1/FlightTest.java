/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author janakansivaloganathan
 */
public class FlightTest {
    
    public FlightTest() {
    }
      
    @Test
    public void testConstructor(){
        System.out.println("testConstructor");
        int flightNumber= 100;
        String origin= "Toronto";
        String destination= "New York";
        String timeDate= "01/01/2021";
        int capacity= 100;
        int basePrice= 1000;
        Flight test= new Flight(flightNumber, origin, destination, timeDate, capacity, basePrice);
        assertEquals(flightNumber, test.getflightNumber());
        assertEquals(origin, test.getorigin());
        assertEquals(destination, test.getdestination());
        assertEquals(timeDate, test.getdepartureTime());
        assertEquals(capacity, test.getcapacity());
        assertEquals(basePrice, test.getoriginalPrice(), 0.0);
    } 
    //This test will pass if the illegal argument exception is thrown
    @Test
    public void testInvalidConstructor(){
        System.out.println("testInvalidConstructor");
        int flightNumber= 100;
        String origin= "Toronto";
        //check to see if the origin and destination are the same (case insensitive)
        String destination= "toronto";
        String timeDate= "01/01/2021 7:00pm";
        //this program has implemented an IllegalArgumentException if the capacity is less than 75 (like a real plane)
        int capacity= 50;
        //this program has a base price of $100 for for a base profit for the company any thing lower throws an IllegalArgumentException
        int basePrice= 100;
        boolean gotEx= false;
        try{
        Flight test= new Flight(flightNumber, origin, destination, timeDate, capacity, basePrice);
        }
        catch(IllegalArgumentException e){
            System.out.println("Sorry you have encountered an error. Either you capacity for the plane was below 75, "
                    + "the base price was below $200, or your origin and desination was the same.");
            gotEx= true;
        }
        assertTrue(gotEx);
    }
    /**
     * Test of bookASeat method, of class Flight.
     */
    @Test
    public void testBookASeat() {
        System.out.println("bookASeat");
        Flight instance = new Flight(100, "Toronto", "London", "01/01/2021 7:00pm", 100, 1500);
        boolean expResult = true;
        boolean result = instance.bookASeat();
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Flight instance = new Flight(100, "Toronto", "London", "01/01/2021 7:00pm", 100, 1500);
        String expResult = "Flight 100, Toronto to London, 01/01/2021 7:00pm, original price: $1500.0";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of getflightNumber method, of class Flight.
     */
    @Test
    public void testGetflightNumber() {
        System.out.println("getflightNumber");
        Flight instance = new Flight(100, "Toronto", "London", "01/01/2021 7:00pm", 100, 1500);
        int expResult = 100;
        int result = instance.getflightNumber();
        assertEquals(expResult, result);

    }

    /**
     * Test of setflightNumber method, of class Flight.
     */
    @Test
    public void testSetflightNumber() {
        System.out.println("setflightNumber");
        int flightNumber = 100;
        Flight instance = new Flight(0, "Toronto", "London", "01/01/2021 7:00pm", 100, 1500);
        instance.setflightNumber(flightNumber);
        System.out.println("Testing of the set funciton " +instance.getflightNumber());
    }

    /**
     * Test of getOrigin method, of class Flight.
     */
    @Test
    public void testGetorigin() {
        System.out.println("getorigin");
        Flight instance = new Flight(100, "Toronto", "London", "01/01/2021 7:00pm", 100, 1500);
        String expResult = "Toronto";
        String result = instance.getorigin();
        assertEquals(expResult, result);

    }

    /**
     * Test of setOrigin method, of class Flight.
     */
    @Test
    public void testSetorigin() {
        System.out.println("setorigin");
        String origin = "Toronto";
        Flight instance = new Flight(100, "aaaaaa", "London", "01/01/2021 7:00pm", 100, 1500);
        instance.setorigin(origin);
        System.out.println("Testing of the set funciton " +instance.getorigin());
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetdestination() {
        System.out.println("getdestination");
        Flight instance = new Flight(100, "Toronto", "London", "01/01/2021 7:00pm", 100, 1500);
        String expResult = "London";
        String result = instance.getdestination();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetdestination() {
        System.out.println("setdestination");
        String destination = "London";
        Flight instance = new Flight(100, "Toronto", "aaaaa", "01/01/2021 7:00pm", 100, 1500);
        instance.setdestination(destination);
        System.out.println("Testing of the set funciton " +instance.getdestination());
    }

    /**
     * Test of getdepartureTime method, of class Flight.
     */
    @Test
    public void testGetdepartureTime() {
        System.out.println("getdepartureTime");
        Flight instance = new Flight(100, "Toronto", "London", "01/01/2021 7:00pm", 100, 1500);
        String expResult = "01/01/2021 7:00pm";
        String result = instance.getdepartureTime();
        assertEquals(expResult, result);

    }

    /**
     * Test of setdepartureTime method, of class Flight.
     */
    @Test
    public void testSetdepartureTime() {
        System.out.println("setdepartureTime");
        String departureTime = "01/01/2021 7:00pm";
        Flight instance = new Flight(100, "Toronto", "London", "00/00/0000 0:00am", 100, 1500);
        instance.setdepartureTime(departureTime);
        System.out.println("Testing of the set funciton " +instance.getdepartureTime());
    }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetcapacity() {
        System.out.println("getcapacity");
        Flight instance = new Flight(100, "Toronto", "London", "01/01/2021 7:00pm", 100, 1500);
        int expResult = 100;
        int result = instance.getcapacity();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCapacity method, of class Flight.
     */
    @Test
    public void testSetcapacity() {
        System.out.println("setcapacity");
        int capacity = 100;
        //this test requies the capacity to be above 75 as the set capacity of a plane for this program is greater than 75
        Flight instance = new Flight(100, "Toronto", "London", "01/01/2021 7:00pm", 2313, 1500);
        instance.setcapacity(capacity);
        System.out.println("Testing of the set funciton " +instance.getcapacity());

    }

    /**
     * Test of getnumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testGetnumberOfSeatsLeft() {
        System.out.println("getnumberOfSeatsLeft");
        Flight instance = new Flight(100, "Toronto", "London", "01/01/2021 7:00pm", 100, 1500);
        int expResult = 100;
        int result = instance.getnumberOfSeatsLeft();
        assertEquals(expResult, result);

    }

    /**
     * Test of setnumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testSetnumberOfSeatsLeft() {
        //try{
        System.out.println("setnumberOfSeatsLeft");
        int remainingSeats = 100;
        Flight instance = new Flight(100, "Toronto", "London", "01/01/2021 7:00pm", 999, 1500);
        instance.setnumberOfSeatsLeft(remainingSeats);
        System.out.println("Testing of the set funciton " +instance.getnumberOfSeatsLeft());
        //}
       // catch(IllegalArgumentException e){
       //     System.out.println("Sorry you have encountered an error. Either you capacity for the plane was below 75, "
       //             + "the base price was below $200, or your origin and desination was the same.");
            
        }
        

    /**
     * Test of getoriginalPrice method, of class Flight.
     */
    @Test
    public void testGetoriginalPrice() {
        System.out.println("getoriginalPrice");
        Flight instance = new Flight(100, "Toronto", "London", "01/01/2021 7:00pm", 100, 1500);
        double expResult = 1500;
        double result = instance.getoriginalPrice();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of setoriginalPrice method, of class Flight.
     */
    @Test
    public void testSetoriginalPrice() {
        //try{
        System.out.println("setoriginalPrice");
        double originalPrice = 1500;
        Flight instance = new Flight(100, "Toronto", "London", "01/01/2021 7:00pm", 100, 2000);
        instance.setoriginalPrice(originalPrice);
        //This output showcases that the original price has been set from 2000 to 1500
        System.out.println("Testing of the set funciton " +instance.getoriginalPrice());
        //}
        //catch(IllegalArgumentException e){
        //    System.out.println("This input test showcases what happens if the original price is below 200");
        //}
        
    }
    
}
