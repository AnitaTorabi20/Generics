package products;

public class Accessory extends Product {
    private String color;

    private static int counter = 10;

    public Accessory(String title, Double price, String color) {
        super(title, price);
        setId(generateId());
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty.");
        }
        this.color = color;
    }

    @Override
    protected String generateId() {
        return "3" + (counter++);
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Color: " + color;
    }
}
