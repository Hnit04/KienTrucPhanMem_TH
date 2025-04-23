package borrow;

public class SpecialEditionBorrowing extends BorrowDecorator {
    public SpecialEditionBorrowing(Borrowable decorated) {
        super(decorated);
    }

    @Override
    public void borrow() {
        super.borrow();
        System.out.println("-> Muon ban dac biet (dich, chu noi, ...).");
    }
}
