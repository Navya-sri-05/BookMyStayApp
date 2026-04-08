import java.io.*;
import java.util.*;

public class BookMyStay {

    static final String FILE_NAME = "inventory.dat";

    public static void main(String[] args) {

        System.out.println("System Recovery");

        Map<String, Integer> inventory = loadInventory();

        // Display current inventory
        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.get("Single"));
        System.out.println("Double: " + inventory.get("Double"));
        System.out.println("Suite: " + inventory.get("Suite"));

        // Save inventory
        saveInventory(inventory);

        System.out.println("Inventory saved successfully.");
    }

    // LOAD (Recovery)
    public static Map<String, Integer> loadInventory() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (Map<String, Integer>) ois.readObject();

        } catch (Exception e) {

            System.out.println("No valid inventory data found. Starting fresh.");

            // default inventory
            Map<String, Integer> defaultInventory = new HashMap<>();
            defaultInventory.put("Single", 5);
            defaultInventory.put("Double", 3);
            defaultInventory.put("Suite", 2);

            return defaultInventory;
        }
    }

    // SAVE (Persistence)
    public static void saveInventory(Map<String, Integer> inventory) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(inventory);

        } catch (Exception e) {
            System.out.println("Error saving inventory.");
        }
    }
}