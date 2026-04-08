import java.util.*;

class BookingHistory {
    private List<Reservation> history = new ArrayList<>();

    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }

    public List<Reservation> getHistory() {
        return history;
    }
}

class BookingReportService {
    public void generateReport(List<Reservation> history) {
        System.out.println("Booking History and Reporting\n");
        System.out.println("Booking History Report");

        for (Reservation r : history) {
            System.out.println("Guest: " + r.getGuestName() +
                    ", Room Type: " + r.getRoomType());
        }
    }
}

public class BookMyStay {
    public static void main(String[] args) {

        BookingHistory bookingHistory = new BookingHistory();

        bookingHistory.addReservation(new Reservation("Abhi", "Single"));
        bookingHistory.addReservation(new Reservation("Subha", "Double"));
        bookingHistory.addReservation(new Reservation("Vanmathi", "Suite"));

        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(bookingHistory.getHistory());
    }
}