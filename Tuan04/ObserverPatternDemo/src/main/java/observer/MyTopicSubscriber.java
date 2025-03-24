package observer;

public class MyTopicSubscriber implements Observer {
    private String name;
    private Subject topic;

    public MyTopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if (msg == null) {
            System.out.println(name + ":: Không có tin nhắn mới");
        } else {
            System.out.println(name + ":: Nhận tin nhắn:: " + msg);
        }
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic = sub;
    }
}
