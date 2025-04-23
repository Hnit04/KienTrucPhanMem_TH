package borrow;

public abstract class BorrowDecorator implements Borrowable {
    protected Borrowable decorated;

    public BorrowDecorator(Borrowable decorated) {
        this.decorated = decorated;
    }

    @Override
    public void borrow() {
        decorated.borrow();
    }
}