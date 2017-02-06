package edu.mum.cs525.finco.accountsubsystem.model;


public interface IAccount {
    void deposite(ITransaction transaction);
    void withdraw(ITransaction transaction);
    void addInterest();
    void generateAccount();
    void evaluateTransaction(ITransaction transaction, IAccount account);
}
