import java.util.List;
import java.util.ArrayList;

public class User {

    private String name;
    private int userId;
    private List<Book> borrowedBooks;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.borrowBook();
    }

    public Boolean returnBook(Book book) {
        for (Book borrowedBook : borrowedBooks) {
            if(borrowedBook.getTitle().equals(book.getTitle())){
                book.returnBook();
                borrowedBooks.remove(book);
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
