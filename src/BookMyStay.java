public class BookMyStay {

        public static void main(String[] args) {

            System.out.println("Hotel Room Inventory Status\n");

            Room single = new SingleRoom();
            Room doubleRoom = new DoubleRoom();
            Room suite = new SuiteRoom();

            RoomInventory inventory = new RoomInventory();

            single.displayDetails();
            System.out.println("Available Rooms: " + inventory.getAvailability("Single Room") + "\n");

            doubleRoom.displayDetails();
            System.out.println("Available Rooms: " + inventory.getAvailability("Double Room") + "\n");

            suite.displayDetails();
            System.out.println("Available Rooms: " + inventory.getAvailability("Suite Room"));
        }
    }