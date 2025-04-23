package book.factory;

import book.*;

public class EBookFactory extends BookFactory {
    @Override
    public Book createBook(String title, String author, String genre) {
        return new EBook(title, author, genre);
    }
}