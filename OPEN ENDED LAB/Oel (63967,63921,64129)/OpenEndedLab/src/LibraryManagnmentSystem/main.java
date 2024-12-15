package LibraryManagnmentSystem;

public class main {
    public static void main(String[] args) {
        Library library = new Library();
        
        // Add books to the library
        library.addBook(new Book("Harry Potter", "J.K. Rowling"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        
        // View available books
        library.viewAvailableBooks();

        // Issue a book
        library.issueBook("Harry Potter");

        // Try to issue the same book again
        library.issueBook("Harry Potter");

        // Return a book
        library.returnBook("Harry Potter");

        // View available books after return
        library.viewAvailableBooks();
    }
}
