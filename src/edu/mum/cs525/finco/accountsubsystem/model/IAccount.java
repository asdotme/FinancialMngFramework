package edu.mum.cs525.finco.accountsubsystem.model;

import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

public interface IAccount {
    void deposite(Transaction transaction);
    void withdraw(Transaction transaction);
    void addInterest();
    void evaluateTransaction(Transaction transaction);
    String generateReport();
    public ICustomer getAccountOwner();
    public double getAccountBalance() ;
    public String getAccountNumber();
}
