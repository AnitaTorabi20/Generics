package products;

public class Book extends Product {
    private String author;
    private String publication;
    private String genre;

    private static int counter = 10;

    public Book(String title, Double price, String author, String publication, String genre) {
        super(title, price);
        setId(generateId());
        setAuthor(author);
        setPublication(publication);
        setGenre(genre);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author name cannot be null or empty.");
        }
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        if (publication == null || publication.trim().isEmpty()) {
            throw new IllegalArgumentException("Publication name cannot be null or empty.");
        }
        this.publication = publication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be null or empty.");
        }
        this.genre = genre;
    }

    @Override
    protected String generateId() {
        return "1" + (counter++);
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Author: " + author
                + " | Publication: " + publication
                + " | Genre: " + genre;
    }
}