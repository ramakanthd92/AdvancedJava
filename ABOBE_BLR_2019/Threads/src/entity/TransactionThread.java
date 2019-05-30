package entity;

public class TransactionThread extends Thread {
    private Account account;
    private TransactionType type;
    private String name;
    private double amt;

    public TransactionThread(Account account, TransactionType type, String name1, double amt) {
        super();
        this.account = account;
        this.type = type;
        this.name = name1;
        this.amt = amt;
    }

    @Override
    public void run() {
        if (type == TransactionType.CREDIT) {
            account.deposit(name,amt);
        } else {
            account.withdraw(name,amt);
        }
    }
}
