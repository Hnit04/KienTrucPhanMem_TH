import book.Book;
import book.EBook;
import book.PhysicalBook;
import book.factory.BookFactory;
import book.factory.EBookFactory;
import book.factory.PhysicalBookFactory;
import borrow.BasicBorrowing;
import borrow.Borrowable;
import borrow.ExtendedBorrowing;
import borrow.SpecialEditionBorrowing;
import library.Library;
import library.observer.LibraryObserver;
import library.observer.LibraryStaff;
import search.SearchByAuthor;
import search.SearchByGenre;
import search.SearchByTitle;
import search.SearchStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. SINGLETON: Khởi tạo thư viện
        Library library = Library.getInstance();

        // 2. OBSERVER: Đăng ký người theo dõi khi có sách mới
        LibraryObserver staff1 = new LibraryStaff("Tinh");
        LibraryObserver staff2 = new LibraryStaff("Hanh");
        library.addObserver(staff1);
        library.addObserver(staff2);

        // 3. FACTORY: Thêm các loại sách khác nhau
        BookFactory ebookFactory = new EBookFactory();
        BookFactory physicalBookFactory = new PhysicalBookFactory();

        Book book1 = ebookFactory.createBook("Clean Code", "Robert C. Martin", "Lap trinh");
        Book book2 = physicalBookFactory.createBook("De men phieu luu ky", "To Hoai", "Van hoc");

        library.addBook(book1); // Thông báo sẽ được gửi đến observers
        library.addBook(book2);

        // 4. STRATEGY: Thử các chiến lược tìm kiếm khác nhau

        System.out.println("\n📚 Tim kiem theo ten:");
        SearchStrategy searchByTitle = new SearchByTitle();
        List<Book> resultTitle = searchByTitle.search(library.getBooks(), "Clean Code");
        resultTitle.forEach(System.out::println);

        System.out.println("\n🖋️ Tim kiem theo tac gia:");
        SearchStrategy searchByAuthor = new SearchByAuthor();
        List<Book> resultAuthor = searchByAuthor.search(library.getBooks(), "To Hoai");
        resultAuthor.forEach(System.out::println);

        System.out.println("\n🏷️ Tim kiem theo the loai:");
        SearchStrategy searchByGenre = new SearchByGenre();
        List<Book> resultGenre = searchByGenre.search(library.getBooks(), "Lap trinh");
        resultGenre.forEach(System.out::println);

        // 5. DECORATOR: Mượn sách với các tính năng bổ sung

        System.out.println("\n🎁 Muon sach co ban:");
        Borrowable basic = new BasicBorrowing();
        basic.borrow();

        System.out.println("\n🎁 Muon sach da duoc gia han:");
        Borrowable extended = new ExtendedBorrowing(basic);
        extended.borrow();

        System.out.println("\n🎁 Muon sach phien ban dac biet:");
        Borrowable special = new SpecialEditionBorrowing(extended);
        special.borrow();
    }
}
