package airlinecheckinsystem_sec51_g4;
import java.util.*;

/*
 * CSC301 Assignment 2
 * Done by: Zayna Wasma (1084503)
 */

public class Luggage_Sec51_G4 {
    // attributes
    private String id;
    private String passengerId;
    private double weight;
    private int length; 
    private int width; 
    private int height;

    // parameterized constructor
    public Luggage_Sec51_G4(String id, String passengerId, double weight, int length, int width, int height) {
        this.id = id;
        this.passengerId = passengerId;
        this.weight = weight;
        this.length = length; 
        this.width = width; 
        this.height = height;
    }

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPassengerId() { return passengerId; }
    public void setPassengerId(String passengerId) { this.passengerId = passengerId; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { 
        if (weight <= 50) { this.weight = weight; } 
        else { System.err.println("Maximum weight reached!"); } }
    public int getLength() { return length; }
    public void setLength(int length) {
        if (length <= 90) { this.length = length; }
        else { System.err.println("Maximum length reached!"); }  }
    public int getWidth() { return width; }
    public void setWidth(int width) {
        if (width <= 60) { this.width = width; }
        else { System.err.println("Maximum width reached!"); } }
    public int getHeight() { return height; }
    public void setHeight(int height) {
        if (height <= 40) { this.height = height; }
        else { System.err.println("Maximum height reached!"); } }
    
    // toString() method
    @Override
    public String toString() {
        return "\n Luggage ID: " + getId() +
                "\t Passenger ID: " + getPassengerId() +
                "\t Weigth: " + getWeight() +
                "\t Length: " + getLength() +
                "\t Width: " + getWidth() +
                "\t Height: " + getHeight();
    }    
} // end of class
