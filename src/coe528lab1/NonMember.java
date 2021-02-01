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
public class NonMember extends Passenger{
 /**
 *NonMember constructor
 * @param name
 * @param age
 */       
    public NonMember(String name, int age){
        super(name, age);
    }
 /**
 *applyDiscount (NonMember)
 * @param p
 * @return p
 * @return p - (p*(0.1))
 */              
     public double applyDiscount(double p){
         if (this.age > 65){
             System.out.println("You are over 65! Applying 10% discount...");
             return p - (p*(0.1));
         }
             System.out.println("Sorry, no discounts available...");
        return p;
    }
    
}
