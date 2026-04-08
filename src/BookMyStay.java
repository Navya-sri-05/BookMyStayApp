import java.util.*;

// Custom Exception
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

public class BookMyStay {

    // Validation Method
    public static void validateBooking(String roomType) throws InvalidBookingException {

        // Valid room types (CASE SENSITIVE)
        if (!(roomType.equals("Single") ||
                roomType.equals("Double") ||
                roomType.equals("Suite"))) {

            throw new InvalidBookingException("Invalid room type selected.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Booking Validation");

            System.out.print("Enter guest name: ");
            String name = sc.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = sc.nextLine();

            // Validate
            validateBooking(roomType);

            // If valid
            System.out.println("Booking successful for " + name);

        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        sc.close();
    }
}