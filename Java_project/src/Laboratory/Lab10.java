package Laboratory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    public void markAsLoaned() {
        isAvailable = false;
    }

    public void markAsAvailable() {
        isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + ", ISBN='" + ISBN + '\'' + ", isAvailable=" + isAvailable + '}';
    }
}

class Reader {
    private int id;
    private String name;
    private String email;

    public Reader(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.markAsLoaned();
            System.out.println(name + " borrowed " + book);
        } else {
            System.out.println("Book is not available!");
        }
    }

    public void returnBook(Book book) {
        book.markAsAvailable();
        System.out.println(name + " returned " + book);
    }
}

class Librarian {
    private int id;
    private String name;
    private String position;

    public Librarian(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public void addBook(List<Book> library, Book book) {
        library.add(book);
        System.out.println("Book added: " + book);
    }

    public void removeBook(List<Book> library, Book book) {
        library.remove(book);
        System.out.println("Book removed: " + book);
    }
}

class Loan {
    private Book book;
    private Reader reader;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(Book book, Reader reader, LocalDate loanDate) {
        this.book = book;
        this.reader = reader;
        this.loanDate = loanDate;
    }

    public void issueLoan() {
        book.markAsLoaned();
        System.out.println("Loan issued for " + book + " to " + reader);
    }

    public void completeLoan() {
        book.markAsAvailable();
        System.out.println("Loan completed for " + book);
    }
}

public class Lab10 {
    public static void main(String[] args) {
        List<Book> library = new ArrayList<>();
        Librarian librarian = new Librarian(1, "Eva", "Manager");
        Reader reader = new Reader(1, "Max", "max@example.com");

        Book book1 = new Book("1984", "George Orwell", "123456789");
        Book book2 = new Book("Brave New World", "Aldous Huxley", "987654321");

        librarian.addBook(library, book1);
        librarian.addBook(library, book2);

        reader.borrowBook(book1);
        reader.returnBook(book1);

        Loan loan = new Loan(book1, reader, LocalDate.now());
        loan.issueLoan();
        loan.completeLoan();
    }
}

