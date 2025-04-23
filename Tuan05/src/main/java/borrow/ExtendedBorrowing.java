package borrow;

public class ExtendedBorrowing extends BorrowDecorator {
    public ExtendedBorrowing(Borrowable decorated) {
        super(decorated);
    }

    @Override
    public void borrow() {
        super.borrow();
        System.out.println("-> Gia han thoi gian muon.");
    }
}