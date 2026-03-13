public class BookMyStay {


        public static void main(String[] args) {

            System.out.println("Room Search\n");

            RoomInventory inventory = new RoomInventory();

            Room single = new SingleRoom();
            Room doubleRoom = new DoubleRoom();
            Room suite = new SuiteRoom();

            int singleAvailable = inventory.getAvailability("Single Room");
            int doubleAvailable = inventory.getAvailability("Double Room");
            int suiteAvailable = inventory.getAvailability("Suite Room");

            if (singleAvailable > 0) {
                single.displayDetails();
                System.out.println("Available: " + singleAvailable + "\n");
            }

            if (doubleAvailable > 0) {
                doubleRoom.displayDetails();
                System.out.println("Available: " + doubleAvailable + "\n");
            }

            if (suiteAvailable > 0) {
                suite.displayDetails();
                System.out.println("Available: " + suiteAvailable);
            }
        }

    }