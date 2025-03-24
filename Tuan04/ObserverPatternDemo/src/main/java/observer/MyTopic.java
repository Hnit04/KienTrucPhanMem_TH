package observer;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyTopic implements Subject {
    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private String message;
    private boolean changed = false;

    @Override
    public void register(Observer obj) {
        if (obj == null) throw new NullPointerException("Observer không được null");
        if (!observers.contains(obj)) observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        if (!changed) return;
        changed = false; // Reset trạng thái trước khi thông báo
        for (Observer obj : observers) {
            obj.update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    // Phương thức để đăng bài viết mới
    public void postMessage(String msg) {
        System.out.println("Message Posted to Topic: " + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}
