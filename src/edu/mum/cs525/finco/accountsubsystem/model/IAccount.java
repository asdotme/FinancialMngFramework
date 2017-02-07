package finalproject.model.account;

import finalproject.model.Transaction.Transaction;

public interface IAccount {
    void deposite(Transaction transaction);
    void withdraw(Transaction transaction);
    void addInterest();
    void evaluateTransaction(Transaction transaction);
    String generateReport();
}
