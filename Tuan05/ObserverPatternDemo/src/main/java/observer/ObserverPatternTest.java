package observer;

public class ObserverPatternTest {
    public static void main(String[] args) {
        // Tạo Subject
        MyTopic topic = new MyTopic();

        // Tạo Observers
        Observer obj1 = new MyTopicSubscriber("Obj1");
        Observer obj2 = new MyTopicSubscriber("Obj2");
        Observer obj3 = new MyTopicSubscriber("Obj3");

        // Đăng ký Observers vào Subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        // Gán Subject cho Observers
        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);

        // Kiểm tra cập nhật (chưa có tin nhắn mới)
        obj1.update();

        // Gửi tin nhắn từ Subject
        topic.postMessage("New Message");
    }
}