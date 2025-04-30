import inventory.Inventory;
import products.*;

public class Main {
    public static void main(String[] args) {
        Inventory<Book> bookInventory = new Inventory<>();
        Inventory<Notebook> notebookInventory = new Inventory<>();
        Inventory<Accessory> accessoryInventory = new Inventory<>();

        Book book1 = new Book("The Alchemist", 390.0, "Paulo Coelho", "HarperOne", "Philosophical Novel");
        Book book2 = new Book("Romeo and Juliet", 420.0, "William Shakespeare", "Simon & Schuster", "Tragedy");

        Notebook notebook1 = new Notebook("Leather Notebook", 120.0, 250, true);
        Notebook notebook2 = new Notebook("Daily Journal", 95.0, 180, false);

        Accessory accessory1 = new Accessory("Stylus Pen", 45.0, "Silver");
        Accessory accessory2 = new Accessory("Wireless Charger", 85.0, "Black");

        bookInventory.addItems(book1);
        bookInventory.addItems(book2);
        notebookInventory.addItems(notebook1);
        notebookInventory.addItems(notebook2);
        accessoryInventory.addItems(accessory1);
        accessoryInventory.addItems(accessory2);

        System.out.println("== Initial Book Inventory ==");
        bookInventory.displayAll();

        System.out.println("\n== Initial Notebook Inventory ==");
        notebookInventory.displayAll();

        System.out.println("\n== Initial Accessory Inventory ==");
        accessoryInventory.displayAll();

        bookInventory.removeItemsById(Integer.parseInt(book1.getId()));
        accessoryInventory.removeItemsById(Integer.parseInt(accessory1.getId()));

        System.out.println("\n== Total Prices After Deletion ==");
        double totalBooks = calculateTotalPrice(bookInventory);
        double totalNotebooks = calculateTotalPrice(notebookInventory);
        double totalAccessories = calculateTotalPrice(accessoryInventory);

        System.out.println("Total Book Price: " + totalBooks);
        System.out.println("Total Notebook Price: " + totalNotebooks);
        System.out.println("Total Accessory Price: " + totalAccessories);

        System.out.println("\n== Finding Existing Product ==");
        Product foundNotebook = notebookInventory.findItemsById(Integer.parseInt(notebook1.getId()));
        if (foundNotebook != null) {
            System.out.println("Found: " + foundNotebook);
        }

        System.out.println("\n== Finding Non-existing Product ==");
        Product notFound = bookInventory.findItemsById(9999);

        System.out.println("\n== Applying Discounts ==");
        bookInventory.applyDiscount("Romeo and Juliet", 15);
        accessoryInventory.applyDiscount("Wireless Charger", 25);

        System.out.println("\n== Final Book Inventory ==");
        bookInventory.displayAll();

        System.out.println("\n== Final Notebook Inventory ==");
        notebookInventory.displayAll();

        System.out.println("\n== Final Accessory Inventory ==");
        accessoryInventory.displayAll();

        System.out.println("\n== Final Total Price ==");
        double finalTotal = calculateTotalPrice(bookInventory)
                + calculateTotalPrice(notebookInventory)
                + calculateTotalPrice(accessoryInventory);
        System.out.println("Grand Total: " + finalTotal);
    }

    public static double calculateTotalPrice(Inventory<? extends Product> inventory) {
        double sum = 0;
        for (Product product : inventory.getItems()) {
            sum += product.getPrice();
        }
        return sum;
    }
}