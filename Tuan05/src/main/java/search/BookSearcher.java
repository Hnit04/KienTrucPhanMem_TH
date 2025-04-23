package search;

import book.Book;
import java.util.*;

public class BookSearcher {
    private SearchStrategy strategy;

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Book> search(List<Book> books, String keyword) {
        if (strategy == null) throw new IllegalStateException("Chua chon chien luoc tim kiem");
        return strategy.search(books, keyword);
    }
}