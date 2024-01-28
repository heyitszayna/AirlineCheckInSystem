package airlinecheckinsystem;
import java.util.*;

public class PriorityServices {
    private String passengerId;
    private int priorityScore;

    // parameterized constructor
    public PriorityServices(String passengerId) {
        this.passengerId = passengerId;
        this.priorityScore = 0;
    }

    // getters and setters
    public String getPassengerId() { return passengerId; }
    public void setPassengerId(String passengerId) { this.passengerId = passengerId; }
    public int getPriorityScore() { return priorityScore; }
    public void setPriorityScore(int priorityScore) { this.priorityScore = priorityScore; }
    
    public void calculatePriority(Passenger passenger) {
        int score = 0;
        
        switch (passenger.getTicketClass()) {
            case "First Class":
                score += 2;
                break;
            case "Business":
                score += 1;
                break;
            case "Economy":
                score+=0;
                break;
        }
        
        if (!"".equals(passenger.getSpecialNeeds())) { score += 5; } 
        
        passenger.getPriorityServices().setPriorityScore(score);
    }

    // toString() method
    @Override
    public String toString() {
        return "\n Passenger ID: " + getPassengerId() +
                "\t Priority Score: " + getPriorityScore();
    }
} // end of class
