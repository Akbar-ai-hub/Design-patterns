package Homework;

import java.util.ArrayList;
import java.util.List;

class Book{
    private String name;
    private String author;
    private String isbn;
    private int count;

    public Book(String name, String author, String isbn, int count) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.count = count;
    }

    public void deliver(Book book){
        if (book.count > 0){
            book.count --;
        }
    }

    public void returnBook(Book book){
        book.count++;
    }

    @Override
    public String toString() {
        return "Книга: " + name + " | Автор: " + author + " | ISBN: " + isbn + " | Количество: " + count;
    }
}

class Reader{
    private String name;
    private int ID;

    public Reader(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Читатель: " + name + " | ID: " + ID;
    }
}

class Library{
    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        books = new ArrayList<>();
        readers = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    public void registReader(Reader reader){
        readers.add(reader);
    }

    public void removeReader(Reader reader){
        readers.remove(reader);
    }

    public void deliver(Book book, Reader reader){
        book.deliver(book);
        System.out.println(book + " выдан на " + reader);
    }

    public void returnBook(Book book){
        book.returnBook(book);
        System.out.println(book + " возвращена.");
    }

}

public class Homework1 {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Война и мир", "Лев Толстой", "12345", 3);
        Book book2 = new Book("Преступление и наказание", "Федор Достоевский", "67890", 2);

        library.addBook(book1);
        library.addBook(book2);

        Reader reader1 = new Reader("Иван Иванов", 1);
        Reader reader2 = new Reader("Мария Петрова", 2);

        library.registReader(reader1);
        library.registReader(reader2);

        library.deliver(book1, reader1);

        library.returnBook(book1);

        library.removeBook(book2);
        library.removeReader(reader2);
    }
}
