package airlinecheckinsystem_sec51_g4;
import java.util.Comparator;

/*
 * CSC301 Assignment 2
 * Done by: Zayna Wasma (1084503)
 */

public class PriorityComparator implements Comparator<Passenger_Sec51_G4> {
    @Override
    public int compare(Passenger_Sec51_G4 p1, Passenger_Sec51_G4 p2) {
        int score1 = p1.getPriorityServices().getPriorityScore();
        int score2 = p2.getPriorityServices().getPriorityScore();
            
        if (score1 > score2) { return -1; }
        else if (score1 < score2) { return 1; }
        else { return 0; }
        }   
} // end of class
