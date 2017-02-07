package edu.mum.cs525.finco.accountsubsystem.model;


public interface IAccount {
    void deposite(Transaction transaction);
    void withdraw(Transaction transaction);
    void addInterest();
    void evaluateTransaction(Transaction transaction);
    String generateReport();
}
