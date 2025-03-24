package observer;

public interface Observer {
    // Cập nhật dữ liệu (được gọi bởi Subject)
    void update();

    // Gán Subject để quan sát
    void setSubject(Subject sub);
}