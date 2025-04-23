package book.factory;

import book.*;

public class PhysicalBookFactory extends BookFactory {
    @Override
    public Book createBook(String title, String author, String genre) {
        return new PhysicalBook(title, author, genre);
    }
}