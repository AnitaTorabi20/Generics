package inventory;

import products.Product;
import java.util.ArrayList;

public class Inventory<T extends Product> {
    private ArrayList<T> items = new ArrayList<>();

    public ArrayList<T> getItems() {
        return items;
    }

    public void setItems(ArrayList<T> items) {
        this.items = items;
    }

    public void addItems(T product) {
        items.add(product);
    }

    public void removeItemsById(int id) {
        String strId = String.valueOf(id);
        boolean removed = items.removeIf(p -> p.getId().equals(strId));
        if (!removed) {
            System.out.println("No product found with ID: " + id);
        }
    }

    public T findItemsById(int id) {
        String strId = String.valueOf(id);
        for (T product : items) {
            if (product.getId().equals(strId)) {
                return product;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
        return null;
    }

    public void applyDiscount(String productName, int discount) {
        if (discount < 0 || discount > 100) {
            System.out.println("Invalid discount percentage: " + discount);
            return;
        }

        for (T product : items) {
            if (product.getTitle().equalsIgnoreCase(productName)) {
                double oldPrice = product.getPrice();
                double newPrice = oldPrice * (1 - discount / 100.0);
                product.setPrice(newPrice);
                System.out.println("Discount applied. New price: " + newPrice);
                return;
            }
        }

        System.out.println("Product with title '" + productName + "' not found.");
    }

    public void displayAll() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (T product : items) {
                System.out.println(product);
            }
        }
    }
}