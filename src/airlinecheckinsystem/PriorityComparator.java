package airlinecheckinsystem;
import java.util.Comparator;

public class PriorityComparator implements Comparator<Passenger> {
    @Override
    public int compare(Passenger p1, Passenger p2) {
        int score1 = p1.getPriorityServices().getPriorityScore();
        int score2 = p2.getPriorityServices().getPriorityScore();
            
        if (score1 > score2) { return -1; }
        else if (score1 < score2) { return 1; }
        else { return 0; }
        }   
} // end of class
