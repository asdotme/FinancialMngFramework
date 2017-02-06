package edu.mum.cs525.finco.accountsubsystem.model;

/**
 * Created by asme on 2/5/17.
 */
public  class AccountLogger implements IAccount {
    IAccount account;
    public AccountLogger(IAccount account){
        this.account = account;
    }

    @Override
    public void deposite(ITransaction transaction) {
        account.deposite(transaction);
    }

    @Override
    public void withdraw(ITransaction transaction) {

        account.withdraw(transaction);
        evaluateTransaction(transaction,account);
    }

    @Override
    public void addInterest() {
        account.addInterest();
    }

    @Override
    public void generateAccount() {
        account.generateAccount();
    }

    @Override
    public void evaluateTransaction(ITransaction transaction, IAccount account) {
        account.evaluateTransaction(transaction, account);
    }

    public void preExecute(){

    }
    public void postExecute(){

    }


}
