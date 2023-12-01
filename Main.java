// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:\n1. Add Item\n2. View Inventory\n3. Exit\nEnter your choice: ");
            int choice = getNumericInput();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double itemPrice = getNumericInput();
                    Item newItem = new Item(itemName, itemPrice);
                    inventory.addItem(newItem);
                    System.out.println("Item added to inventory.");
                    break;
                case 2:
                    displayInventory(inventory);
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static int getNumericInput() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
        }
        return (int) scanner.nextDouble();
    }

    private static void displayInventory(Inventory inventory) {
        System.out.println("\nInventory:");
        List<Item> items = inventory.getItems();
        if (items.isEmpty()) {
            System.out.println("No items in the inventory.");
        } else {
            for (Item item : items) {
                System.out.println(item.getName() + " - $" + item.getPrice());
            }
        }
    }
}
