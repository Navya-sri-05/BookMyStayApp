import java.util.*;

public class  BookMyStay {

    static class Service {
        String name;
        double cost;

        Service(String name, double cost) {
            this.name = name;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection");

        String reservationId = "Single-1";

        Service breakfast = new Service("Breakfast", 500);
        Service wifi = new Service("WiFi", 300);
        Service spa = new Service("Spa", 700);

        List<Service> services = new ArrayList<>();
        services.add(breakfast);
        services.add(wifi);
        services.add(spa);

        Map<String, List<Service>> serviceMap = new HashMap<>();
        serviceMap.put(reservationId, services);

        double totalCost = 0;
        for (Service s : serviceMap.get(reservationId)) {
            totalCost += s.cost;
        }

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}