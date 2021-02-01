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
public abstract class Passenger {
    String name;
    int age;
/**
 *Passenger constructor (abstract class)
 * @param name 
 * @param age
 */    
    public Passenger(String name, int age){
        this.name= name;
        this.age= age;
        
    }
/**
 *applyDiscount
 * @param p
 */    
    public abstract double applyDiscount(double p);
    
/**
 *getName
 * @return name
 */
    public String getName() {
        return name;
    }
/**
 *setName
 * @param name
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 *getAge
 * @return age
 */
    public int getAge() {
        return age;
    }
/**
 *setAge
 * @param age
 */
    public void setAge(int age) {
        this.age = age;
    }
    
    
        
    
    
}
