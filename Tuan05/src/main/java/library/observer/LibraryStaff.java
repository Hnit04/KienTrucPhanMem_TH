package library.observer;

public class LibraryStaff implements LibraryObserver {
    private String name;

    public LibraryStaff(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("[Thong bao cho nhan vien " + name + "]: " + message);
    }
}
