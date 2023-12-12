public class Book {
    private String title;
    private String author;
    private int quantity;
    private String genre;

    public Book(String title, String author, int quantity, String genre) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getGenre() {
        return genre;
    }

    public void borrowBook() {
        if (quantity > 0) {
            quantity--;
            System.out.println("Book borrowed successfully: " + title);
        } else {
            System.out.println("Sorry, the book is not available for borrowing: " + title);
        }
    }

    public void returnBook() {
        quantity++;
        System.out.println("Book returned successfully: " + title);
    }
}
