package book.factory;

import book.Book;

public abstract class BookFactory {
    public abstract Book createBook(String title, String author, String genre);
}
