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
public class Member extends Passenger{
    
    int yearsOfMembership;
 /**
 *Member constructor
 * @param name
 * @param age
 */       
    public Member(String name, int age){
        super(name, age);
    }
 /**
 *applyDiscount
 * @param p
 * @return p - (p*(0.1))
 */       
    public double applyDiscount(double p){
        if (yearsOfMembership > 1){
            System.out.println("Applying 10% discount...");
            return p - (p*(0.1));
        }
        else if(yearsOfMembership > 5){
            System.out.println("Applying 50% discount...");
            return p - (p*(0.5));
        }
        else
        return p;
    }
    
    
    
}
