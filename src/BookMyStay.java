import java.util.*;

// Booking Service with synchronized method
class BookingService {

    private Map<String, Integer> inventory = new HashMap<>();
    private Map<String, Integer> roomCounter = new HashMap<>();

    public BookingService() {
        inventory.put("Single", 2);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        roomCounter.put("Single", 1);
        roomCounter.put("Double", 1);
        roomCounter.put("Suite", 1);
    }

    // synchronized = thread safety
    public synchronized void bookRoom(String guestName, String roomType) {

        if (inventory.get(roomType) > 0) {

            int roomNum = roomCounter.get(roomType);
            String roomId = roomType + "-" + roomNum;

            // update counter + inventory
            roomCounter.put(roomType, roomNum + 1);
            inventory.put(roomType, inventory.get(roomType) - 1);

            System.out.println("Booking confirmed for Guest: " +
                    guestName + ", Room ID: " + roomId);

        } else {
            System.out.println("No rooms available for " + guestName);
        }
    }

    public void displayInventory() {
        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.get("Single"));
        System.out.println("Double: " + inventory.get("Double"));
        System.out.println("Suite: " + inventory.get("Suite"));
    }
}

// Thread class
class BookingThread extends Thread {

    private BookingService service;
    private String guestName;
    private String roomType;

    public BookingThread(BookingService service, String guestName, String roomType) {
        this.service = service;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public void run() {
        service.bookRoom(guestName, roomType);
    }
}

// MAIN
public class BookMyStay {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation\n");

        BookingService service = new BookingService();

        // Multiple threads (simultaneous bookings)
        Thread t1 = new BookingThread(service, "Abhi", "Single");
        Thread t2 = new BookingThread(service, "Vanmathi", "Double");
        Thread t3 = new BookingThread(service, "Kural", "Suite");
        Thread t4 = new BookingThread(service, "Subha", "Single");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // wait for all threads
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        service.displayInventory();
    }
}