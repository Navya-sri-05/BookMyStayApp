import java.util.*;

public class BookMyStay {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation\n");

        // Inventory (room availability)
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        // Assume a confirmed booking exists
        String reservationId = "Single-1";
        String roomType = "Single";

        // Stack for rollback (LIFO)
        Stack<String> rollbackStack = new Stack<>();

        // --- Cancellation Process ---
        if (reservationId != null) {

            // Push released room ID to stack
            rollbackStack.push(reservationId);

            // Restore inventory
            inventory.put(roomType, inventory.get(roomType) + 1);

            System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
        } else {
            System.out.println("Cancellation failed: Reservation not found.");
            return;
        }

        // --- Rollback History ---
        System.out.println("\nRollback History (Most Recent First):");

        while (!rollbackStack.isEmpty()) {
            System.out.println("Released Reservation ID: " + rollbackStack.pop());
        }

        // --- Updated Inventory ---
        System.out.println("\nUpdated " + roomType + " Room Availability: " + inventory.get(roomType));
    }
}