package products;

public class Notebook extends Product {
    private int pageCount;
    private boolean isHardCover;

    private static int counter = 10;

    public Notebook(String title, Double price, int pageCount, boolean isHardCover) {
        super(title, price);
        setId(generateId());
        setPageCount(pageCount);
        this.isHardCover = isHardCover;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be greater than zero.");
        }
        this.pageCount = pageCount;
    }

    public boolean isHardCover() {
        return isHardCover;
    }

    public void setHardCover(boolean hardCover) {
        isHardCover = hardCover;
    }

    @Override
    protected String generateId() {
        return "2" + (counter++);
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Page Count: " + pageCount
                + " | Hard Cover: " + (isHardCover ? "Yes" : "No");
    }
}