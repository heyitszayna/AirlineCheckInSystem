package airlinecheckinsystem_sec51_g4;

/*
 * CSC301 Assignment 2
 * Done by: Zayna Wasma (1084503)
 */

public class Passenger_Sec51_G4 {
    // attributes
    private String id;
    private String name;
    private String ticketClass;
    private int luggageCount;
    private String specialNeeds;
    private PriorityServices_Sec51_G4 priority;
    
    // paramterized constructor
    public Passenger_Sec51_G4(String id, String name, String ticketClass, int luggageCount, String specialNeeds) {
        this.id = id;
        this.name = name;
        this.ticketClass = ticketClass;
        this.luggageCount = luggageCount;
        this.specialNeeds = specialNeeds;
        this.priority = new PriorityServices_Sec51_G4(id);
    }

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTicketClass() { return ticketClass; }
    public void setTicketClass(String ticketClass) { this.ticketClass = ticketClass; }
    public int getLuggageCount() { return luggageCount; }
    public void setLuggageCount(int luggageCount) { this.luggageCount = luggageCount; }
    public String getSpecialNeeds() { return specialNeeds; }
    public void setSpecialNeeds(String specialNeeds) { this.specialNeeds = specialNeeds; }
    public PriorityServices_Sec51_G4 getPriorityServices() { return priority; }

    // toString() method
    @Override
    public String toString() {
        return "\n Passenger ID: " + getId() +
                "\t Passenger Name: " + getName() +
                "\t Ticket Class: " + getTicketClass() +
                "\t Luggage Count: " + getLuggageCount() +
                "\t Special Needs (if any): " + getSpecialNeeds();
    }
    
    /*@Override
    public int compareTo(Passenger_Sec51_G4 other) {
        // Compare passengers based on their priority scores
        int score1 = this.priority.getPriorityScore();
        int score2 = other.priority.getPriorityScore();
        return Integer.compare(score2, score1);
    }*/
} // end of class
