package client;

import entity.Account;
import entity.TransactionThread;
import entity.TransactionType;

public class AccountClient {
    public static void main(String[] args) {
        Account account = new Account(5000);
        TransactionThread t1 = new TransactionThread(account, TransactionType.CREDIT, "A", 2500);
        TransactionThread t2 = new TransactionThread(account, TransactionType.CREDIT, "\tB", 3000);
        TransactionThread t3 = new TransactionThread(account, TransactionType.DEBIT, "\t\tC", 2000);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final Balance : " + account.getBalance());
    }
}
