package airlinecheckinsystem_sec51_g4;
import java.util.*;

/*
 * CSC301 Assignment 2
 * Done by: Zayna Wasma (1084503)
 */

public class AirlineCheckInSystem_Sec51_G4 {
  
    // Data structures for managing passengers, luggage, and priority services.
    private Queue<Passenger_Sec51_G4> passengersQueue;
    private Stack<Luggage_Sec51_G4> luggageStack;
    private PriorityQueue<Passenger_Sec51_G4> priorityServicesQueue;

    // Constructor
    public AirlineCheckInSystem_Sec51_G4() {
        // Initialize data structures
        passengersQueue = new LinkedList<Passenger_Sec51_G4>();
        luggageStack = new Stack<Luggage_Sec51_G4>();
        priorityServicesQueue = new PriorityQueue<Passenger_Sec51_G4>();
    }

    // Methods
    public void enqueuePassenger(Passenger_Sec51_G4 passenger) {
        // Logic to add passenger to the passengers queue
        passengersQueue.offer(passenger);
    }

    public void enqueuePriorityPassenger(Passenger_Sec51_G4 passenger) {
        // Logic to add passenger to the priority services queue
        priorityServicesQueue.offer(passenger);
    }

    public void pushLuggage(Luggage_Sec51_G4 luggage) {
        // Logic to push luggage to the luggage stack
        luggageStack.push(luggage);
    }

    public Passenger_Sec51_G4 dequeuePassenger() {
        // Logic to serve the next passenger (considering priority)
        Passenger_Sec51_G4 dequeuedPassenger = passengersQueue.poll();
        // Return the dequeued passenger
        return dequeuedPassenger; 
    }

    public Luggage_Sec51_G4 popLuggage() {
        // Logic to process the luggage from the luggage stack
        Luggage_Sec51_G4 popedLuggage = luggageStack.pop();
        // Return the processed luggage
        return popedLuggage; 
    }

    public Passenger_Sec51_G4 getNextPassenger() {
        // Logic to view the next passenger to be served without dequeuing
        // Return the next passenger
        if (!passengersQueue.isEmpty()) { return passengersQueue.peek(); }
        else { return null; }
    }

    public Luggage_Sec51_G4 getTopLuggage() {
        // Logic to view the top luggage without popping
        // Return the top luggage
        if (!luggageStack.isEmpty()) { return luggageStack.peek(); }
        else { return null; }
    }
    
    public static void main(String[] args) {
        AirlineCheckInSystem_Sec51_G4 checkInSystem = new AirlineCheckInSystem_Sec51_G4();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Airline Check-In System Menu:");
            System.out.println("1. Register Passenger");
            System.out.println("2. Enqueue Priority Passenger");
            System.out.println("3. Push Luggage");
            System.out.println("4. Dequeue Passenger");
            System.out.println("5. Pop Luggage");
            System.out.println("6. View Next Passenger");
            System.out.println("7. View Top Luggage");
            System.out.println("8. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            
            switch (choice) {
                case 1: {
                    System.out.print("Enter Passenger ID: ");
                    String Id = scanner.nextLine();
                    System.out.print("Enter Passenger Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Ticket Class (Economy, Business, First Class): ");
                    String ticketClass = scanner.nextLine();
                    System.out.print("Enter Luggage Count: ");
                    int luggageCount = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Special Needs (if any): ");
                    String specialNeeds = scanner.nextLine();
                    checkInSystem.enqueuePassenger(new Passenger_Sec51_G4(Id, name, ticketClass, luggageCount, specialNeeds));
                    System.out.println("Passenger added to the queue.");
                    break; }
                case 2: {
                    // Logic to enqueue a priority passenger
                    System.out.print("Enter passenger ID to add to priority queue: ");
                    String id = scanner.nextLine();

                    for (Passenger_Sec51_G4 passenger : checkInSystem.passengersQueue) {
                        if (passenger.getId().equals(id)) {
                            checkInSystem.enqueuePriorityPassenger(passenger);
                            System.out.println("Passenger added to the priority queue.");
                            break;
                        }
                    }
                    break;}
                case 3: {
                    // Logic to push luggage
                    System.out.print("Enter Luggage ID: ");
                    String luggageId = scanner.nextLine();
                    System.out.print("Enter Passenger ID: ");
                    String passengerId = scanner.nextLine();
                    System.out.print("Enter Weight: ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Enter Length: ");
                    int length = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Width: ");
                    int width = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Height: ");
                    int height = scanner.nextInt();
                    scanner.nextLine(); 
                    checkInSystem.pushLuggage(new Luggage_Sec51_G4(luggageId, passengerId, weight, length, width, height));
                    System.out.println("Luggage added to the stack.");
                    break; }
                case 4:
                    // Logic to dequeue a passenger
                    Passenger_Sec51_G4 removedPassenger = checkInSystem.dequeuePassenger();
                    System.out.println("Removed passenger: " + removedPassenger);
                    break;
                case 5:
                    // Logic to pop luggage
                    Luggage_Sec51_G4 removedLuggage = checkInSystem.popLuggage();
                    System.out.println("Removed luggage: " + removedLuggage);
                    break;
                case 6:
                    // Logic to view next passenger
                    Passenger_Sec51_G4 nextPassenger = checkInSystem.getNextPassenger();
                    System.out.println("Next passenger: " + nextPassenger);
                    break;
                case 7:
                    // Logic to view top luggage
                    Luggage_Sec51_G4 topLuggage = checkInSystem.getTopLuggage();
                    System.out.println("Top luggage: " + topLuggage);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    } // end of main
} // end of class
