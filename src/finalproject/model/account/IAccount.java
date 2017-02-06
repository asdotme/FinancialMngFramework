package finalproject.model.account;

import finalproject.controller.account.EvaluateFunctor;
import finalproject.model.Transaction.ITransaction;

public interface IAccount {
    void deposite(ITransaction transaction);
    void withdraw(ITransaction transaction);
    void addInterest();
    void generateAccount();
    void evaluateTransaction(ITransaction transaction, IAccount account);
}
