import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library("My Library");
        List<User> users =new ArrayList<>();
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a book to the library");
            System.out.println("2. Remove a book from the library");
            System.out.println("3. Display the list of books in the library");
            System.out.println("4. Search for a book in the library");
            System.out.println("5. Borrow a book from the library");
            System.out.println("6. Return a book to the library");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a book to the library
                    System.out.print("Enter book title: ");
                    String title = scanner.next();
                    System.out.print("Enter book author: ");
                    String author = scanner.next();
                    System.out.print("Enter book quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter book genre: ");
                    String genre = scanner.next();

                    Book newBook = new Book(title, author, quantity, genre);
                    library.addBook(newBook);
                    break;

                case 2:
                    // Remove a book from the library
                    System.out.print("Enter the title of the book to remove: ");
                    String removeTitle = scanner.next();
                    Book bookToRemove = library.searchBook(removeTitle);
                    if (bookToRemove != null) {
                        library.removeBook(bookToRemove);
                    } else {
                        System.out.println("Book not found in the library.");
                    }
                    break;

                case 3:
                    // Display the list of books in the library
                    library.displayBookList();
                    break;

                case 4:
                    // Search for a book in the library
                    System.out.print("Enter the title of the book to search: ");
                    String searchTitle = scanner.next();
                    Book foundBook = library.searchBook(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook.getTitle() + " by " + foundBook.getAuthor());
                    } else {
                        System.out.println("Book not found in the library.");
                    }
                    break;

                case 5:
                    // Borrow a book from the library
                    System.out.print("Enter user name: ");
                    String name = scanner.next();
                    System.out.print("Enter user id: ");
                    int id = Integer.parseInt(scanner.next());
                    User user = new User(name, id);
                    users.add(user);
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.next();
                    Book borrowBook = library.searchBook(borrowTitle);
                    if (borrowBook != null) {
                        user.borrowBook(borrowBook);
                    } else {
                        System.out.println("Book not found in the library.");
                    }
                    break;

                case 6:
                    // Return a book to the library
                    System.out.print("Enter user name: ");
                    String name1 = scanner.next();
                    System.out.print("Enter user id: ");
                    int id1 = Integer.parseInt(scanner.next());
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.next();
                    Book returnBook = library.searchBook(returnTitle);
                    Boolean flag=Boolean.FALSE;
                    for (User user1 : users) {
                        if(user1.getName().equals(name1)&&user1.getUserId()==id1)
                        {
                            if (returnBook != null) {
                                if(user1.returnBook(returnBook)){
                                    System.out.println("Book returned successfully");
                                }else{
                                    System.out.println("You haven't borrowed this book.");
                                }
                            } else {
                                System.out.println("Book not found in the library.");
                            }
                            flag=Boolean.TRUE;
                        }
                    }
                    if(!flag)
                        System.out.println("not found user");
                    break;

                case 0:
                    // Exit the program
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}