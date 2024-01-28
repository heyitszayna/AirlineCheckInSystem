package airlinecheckinsystem;
import java.util.*;

public class AirlineCheckInSystem {
  
    // Data structures for managing passengers, luggage, and priority services.
    private Queue<Passenger> passengersQueue;
    private Stack<Luggage> luggageStack;
    private PriorityQueue<Passenger> priorityServicesQueue;

    // Constructor
    public AirlineCheckInSystem() {
        // Initialize data structures
        passengersQueue = new LinkedList<Passenger>();
        luggageStack = new Stack<Luggage>();
        priorityServicesQueue = new PriorityQueue<Passenger>();
    }

    // Methods
    public void enqueuePassenger(Passenger passenger) {
        // Logic to add passengers to the passenger queue
        passengersQueue.offer(passenger);
    }

    public void enqueuePriorityPassenger(Passenger passenger) {
        // Logic to add passengers to the priority services queue
        priorityServicesQueue.offer(passenger);
    }

    public void pushLuggage(Luggage luggage) {
        // Logic to push luggage to the luggage stack
        luggageStack.push(luggage);
    }

    public Passenger dequeuePassenger() {
        // Logic to serve the next passenger (considering priority)
        Passenger dequeuedPassenger = passengersQueue.poll();
        // Return the dequeued passenger
        return dequeuedPassenger; 
    }

    public Luggage popLuggage() {
        // Logic to process the luggage from the luggage stack
        Luggage popedLuggage = luggageStack.pop();
        // Return the processed luggage
        return popedLuggage; 
    }

    public Passenger getNextPassenger() {
        // Logic to view the next passenger to be served without dequeuing
        // Return the next passenger
        if (!passengersQueue.isEmpty()) { return passengersQueue.peek(); }
        else { return null; }
    }

    public Luggage getTopLuggage() {
        // Logic to view the top luggage without popping
        // Return the top luggage
        if (!luggageStack.isEmpty()) { return luggageStack.peek(); }
        else { return null; }
    }
    
    public static void main(String[] args) {
        AirlineCheckInSystem checkInSystem = new AirlineCheckInSystem();
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
                    checkInSystem.enqueuePassenger(new Passenger(Id, name, ticketClass, luggageCount, specialNeeds));
                    System.out.println("Passenger added to the queue.");
                    break; }
                case 2: {
                    // Logic to enqueue a priority passenger
                    System.out.print("Enter passenger ID to add to priority queue: ");
                    String id = scanner.nextLine();

                    for (Passenger passenger : checkInSystem.passengersQueue) {
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
                    checkInSystem.pushLuggage(new Luggage(luggageId, passengerId, weight, length, width, height));
                    System.out.println("Luggage added to the stack.");
                    break; }
                case 4:
                    // Logic to dequeue a passenger
                    Passenger removedPassenger = checkInSystem.dequeuePassenger();
                    System.out.println("Removed passenger: " + removedPassenger);
                    break;
                case 5:
                    // Logic to pop luggage
                    Luggage removedLuggage = checkInSystem.popLuggage();
                    System.out.println("Removed luggage: " + removedLuggage);
                    break;
                case 6:
                    // Logic to view next passenger
                    Passenger nextPassenger = checkInSystem.getNextPassenger();
                    System.out.println("Next passenger: " + nextPassenger);
                    break;
                case 7:
                    // Logic to view top luggage
                    Luggage topLuggage = checkInSystem.getTopLuggage();
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
