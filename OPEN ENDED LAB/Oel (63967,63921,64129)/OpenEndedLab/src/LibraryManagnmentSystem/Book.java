package LibraryManagnmentSystem;

class Book {
    String title;
    String author;
    boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false; // Initially, the book is available
    }

    public void issueBook() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    public boolean isAvailable() {
        return !isIssued;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Available: " + (isIssued ? "No" : "Yes");
    }
}

class Library {
    class Node {
        Book book;
        Node next;

        public Node(Book book) {
            this.book = book;
            this.next = null;
        }
    }

    private Node head;

    public Library() {
        head = null;
    }

    public void addBook(Book book) {
        Node newNode = new Node(book);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void issueBook(String title) {
        Node current = head;
        while (current != null) {
            if (current.book.title.equals(title) && current.book.isAvailable()) {
                current.book.issueBook();
                System.out.println("Book issued: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Book not available or already issued.");
    }

    public void returnBook(String title) {
        Node current = head;
        while (current != null) {
            if (current.book.title.equals(title) && !current.book.isAvailable()) {
                current.book.returnBook();
                System.out.println("Book returned: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("This book was not issued.");
    }

    public void viewAvailableBooks() {
        Node current = head;
        System.out.println("Available Books:");
        while (current != null) {
            if (current.book.isAvailable()) {
                System.out.println(current.book);
            }
            current = current.next;
        }
    }

}

