/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528lab1;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author janakansivaloganathan
 * Course: COE 528
 * Student Number: 500960836
 */
public class Manager {
   static ArrayList<Flight> flights= new ArrayList<Flight>();
   static ArrayList<Ticket> tickets= new ArrayList<Ticket>();
   static Scanner scan= new Scanner(System.in); 
 /**
 * Manager contains default constructor
 */ 

 /**
 *createFlights
 *creates flight objects and appends them to the flights ArrayList
 */   
   public static void createFlights(){
        System.out.println("Please enter the following information:");
        System.out.println("Flight Number: ");
        int fNumber= scan.nextInt();
        for(Flight check : flights){
                while(check.getflightNumber() == fNumber){
                    System.out.println("Flight number in use... Please pick another: ");
                    fNumber= scan.nextInt();
                }
            }
        scan.nextLine();
        System.out.println("Flight origin: ");
        String origin= scan.nextLine();
        System.out.println("Flight destination: ");
        String destination= scan.nextLine();
        System.out.println("Flight departure time in the following format: DD/MM/YYYY 00:00am/pm");
        String date= scan.nextLine();
        System.out.println("The plane capacity: ");
        int capacity= scan.nextInt();
        System.out.println("The original price for a ticket: ");
        int price= scan.nextInt();
        Flight x= new Flight(fNumber, origin, destination, date, capacity, price);
        flights.add(x);
        System.out.println("Flight created! Printout:");
        System.out.println("--------------------------------------");
        System.out.println(x);
        
    }
 /**
 *displayAvailableFlights
 * @param origin
 * @param destination
 * checks if the selected origin and destination are within one of the flight objects in flights ArrayList
 */       
    public static void displayAvailableFlights(String origin, String destination){
        if(!flights.isEmpty()){
            for(Flight check : flights){
                if(check.getorigin().equalsIgnoreCase(origin) && check.getdestination().equalsIgnoreCase(destination)){
                    System.out.println("Displaying available flights...");
                    if(check.bookASeat()){
                        System.out.println(check);
                    }
                    else{
                        System.out.println("No flights available...");
                    }
                }
                else{
                        System.out.println("No flights available...");
                }
            }
        }
        else
            System.out.println("No flights on platform today. Please create flights from main menu");
    }
    
 /**
 *getFlight
 * @param flightNumber
 * @return check
 * Searches for the flight number, if it is not found or there is no flight number related to the parameter, then null will be returned
 */       
    public static Flight getFlight(int flightNumber){
      System.out.println("Getting the flight...");
      if(!flights.isEmpty()){
        for(Flight check : flights){
            if(check.getflightNumber() == flightNumber){
                System.out.println("Flight found!");
                return check;
            }
            else
                System.out.println("Sorry flight not found.");
               return null;
        }
      }
      System.out.println("No flights available."); 
      return null;
    }
 /**
 *bookSeat
 * @param flightNumber
 * @param p
 * This method checks if the flight number is present
 * The method will check if the object is a subclass of Passenger and then create a member or non-member object depending on the user input
 * The ticket will be created for the according member status and it will be appended to the ticket ArrayList
 * The passenger will be up casted to a new object of either non-member or member for the discount to apply specifically for that class
 */       
    public static void bookSeat(int flightNumber, Passenger p){
        int x;
        double memberDiscount;
        double nonmemberDiscount;
        for(Flight check : flights){
            if(check.getflightNumber() == flightNumber){
                if(check.bookASeat()){
                    if(p instanceof Member){   
                        Member a= (Member)p;
                        System.out.println("How many years have they been a member/travelling for?: ");
                        x= scan.nextInt();
                        a.yearsOfMembership = x;
                        memberDiscount= a.applyDiscount(check.getoriginalPrice());
                        Ticket one= new Ticket(a, check, memberDiscount);
                        tickets.add(one);
                        check.bookASeat();
                        System.out.println("Congrats! their ticket is made!");
                        System.out.println("--------------------------------------");
                        System.out.println(one);
                    }
                    else{
                        NonMember a= (NonMember)p;
                        System.out.println("Applying your discount according to age...");
                        nonmemberDiscount= a.applyDiscount(check.getoriginalPrice());
                        Ticket two= new Ticket(a, check, nonmemberDiscount);
                        tickets.add(two);
                        check.bookASeat();
                        System.out.println("Congrats! their ticket is made...");
                        System.out.println("--------------------------------------");
                        System.out.println(two);
                    }
                }
            }
        }
    }
          
 /**
 *Main
 * @param args
 * The main evokes a UX similar which presents a menu for the user to use. 
 * In order to use the main function properly please follow the following data types for the commands it requests:
 * destination: string
 * origin: string
 * age: integer
 * destinationTime: string
 * price: double
 * capacity: integer
 * and for the single command answers such as yes or no please reply with y or n characters else the program will crash. (This can be fixed with a try catch statement)
 * after you have completed an activity you are able to go back to the main menu and select another operation.
 * to fully exit the application please hit 5 on the main menu and then 0 at the exit terminal
 * thanks for utilizing flight manager 2.0!
 */         
    public static void main(String[] args){
        int selector;
        int x;
        String origin;
        String destination;
        int flightNumber;
        Passenger p;
        String name;
        int age;
        boolean system= true;
        System.out.println("--------------------------------------");
        
        while(system){
            System.out.println("Welcome to the flight system, Manager!");
            System.out.println("What would you like to do today?");
            System.out.println("To Create a Flight: Type 1");
            System.out.println("To Display Available Flights: Type 2");
            System.out.println("To Check a Flight (Get a Flight): Type 3");
            System.out.println("To Book a Seat: Type 4");
            System.out.println("To Close Flight System: Type 5");
            System.out.print("\nPlease type your number: ");
            selector= scan.nextInt();
        
        if(selector == 1){
            System.out.println("\n**Please be aware that creating a flight with a capacity less than 75, having the same desitnation"
                           + "\nand origin, and implementing the original price less than 200 will throw an illegal argument error.**\n");
            char agree;
            boolean input= true;
            createFlights();
                while(input){
                System.out.println("Would you like to create another flight? Y for yes N for no: ");
                agree= scan.next().charAt(0);
                if(agree == 'y' || agree == 'Y'){
                    createFlights();
                    input= true;
                }
                else if(agree == 'n' || agree == 'N'){
                    input= false;
                }
                else
                    input= true;
                }
            }
                    
        
        
        if(selector == 2){
            System.out.println("Please enter the origin: ");
            scan.nextLine();
            origin= scan.nextLine();
            System.out.println("Please enter the destination: ");
            destination= scan.nextLine();
            displayAvailableFlights(origin, destination);
        }
        
        if(selector == 3){
            char agree;
            boolean input= true;
            System.out.println("What flight number do you want to select?");
            x= scan.nextInt();
            if(getFlight(x) != null){
                while(input){
                System.out.println("Would you like to view the choosen flight? Y for yes N for no: ");
                agree= scan.next().charAt(0);
                if(agree == 'y' || agree == 'Y'){
                    System.out.println(getFlight(x));
                    input= false;
                }
                else if(agree == 'n' || agree == 'N'){
                    input= false;
                }
                else
                    input= true;
                }
            }
            else 
                System.out.println("Returned null, the identified flight number is not available.");
        }
        
        if(selector == 4){
            boolean input= true;
            boolean flightCheck= true;
            char agree;
            System.out.println("Let's book a flight for your client.");
            while(flightCheck){
                System.out.println("What flight number would the client like to get on?");
                flightNumber= scan.nextInt();
                if(!(flights.isEmpty())){
                    for(Flight check : flights){
                        if(check.getflightNumber() == flightNumber){
                            System.out.println("Let's know more about our client.");
                            System.out.println("What is the client's name?: ");
                            scan.nextLine();
                            name= scan.nextLine();
                            System.out.println("What is their age?");
                            age= scan.nextInt();
                            while(input){
                                System.out.println("Are they a frequent flyer or member? Y for yes N for no:");
                                agree= scan.next().charAt(0);
                                if(agree == 'y' || agree == 'Y'){
                                    p= new Member(name, age);
                                    input= false;
                                    System.out.println("Perfect, we are in the process of booking...");
                                    bookSeat(flightNumber, p);
                                }
                                else if(agree == 'n' || agree == 'N'){
                                    p= new NonMember(name, age);
                                    input= false;
                                    System.out.println("Perfect, we are in the process of booking...");
                                    bookSeat(flightNumber, p);
                                }
                                else
                                    input= true;
                                }
                            flightCheck= false;
                            }   
                        else 
                            System.out.println("Sorry the selected flight is not available...");
                    }
                }
                else {
                    System.out.println("Sorry the selected flight is not available... Please check display flights");
                    flightCheck= false;
                }
            }
        }
        System.out.print("\n");
        System.out.println("To end session: type 0 | To go back to main menu: type 1 | To display all flights: type 2 | To display all tickets: type 3");
        selector= scan.nextInt();
        switch(selector){
            case 0:
                system= false;
            case 1:
                System.out.print("\n");
                break;
            case 2:
                if(!flights.isEmpty()){
                    System.out.println("--------------------------------------");
                    for(Flight scan : flights){
                        System.out.println(scan);
                    }
                    System.out.println("\n");
                    break;
                }
                else{
                    System.out.println("Sorry no flights are available at the moment");
                    System.out.println("\n");
                    break;
                }
            case 3:
                if(!tickets.isEmpty()){
                    System.out.println("--------------------------------------");
                    for(Ticket scan : tickets){
                        System.out.println(scan);
                    }
                    System.out.print("\n");
                    break;
                }
                else{
                    System.out.println("Sorry no tickets are available at the moment");
                    System.out.println("\n");
                    break;
                }
            default:
                break;
            }
        }
    }
}
