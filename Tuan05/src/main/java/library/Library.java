package library;

import book.Book;
import library.observer.LibraryObserver;

import java.util.*;

public class Library {
    private static Library instance;
    private List<Book> books = new ArrayList<>();
    private List<LibraryObserver> observers = new ArrayList<>();

    private Library() {}

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addObserver(LibraryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LibraryObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (LibraryObserver o : observers) {
            o.update(message);
        }
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers("Sach moi duoc them: " + book.getTitle());
    }

    public List<Book> getBooks() {
        return books;
    }
}