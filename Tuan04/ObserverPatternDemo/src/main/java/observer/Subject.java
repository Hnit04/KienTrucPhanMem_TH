package observer;

public interface Subject {
    // Đăng ký (register) và hủy đăng ký (unregister) Observer
    void register(Observer obj);
    void unregister(Observer obj);

    // Thông báo cho tất cả Observer khi có thay đổi
    void notifyObservers();

    // Lấy thông tin cập nhật từ Subject
    Object getUpdate(Observer obj);
}