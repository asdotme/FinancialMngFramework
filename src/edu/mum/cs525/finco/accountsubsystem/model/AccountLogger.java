package edu.mum.cs525.finco.accountsubsystem.model;

import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

public  class AccountLogger implements IAccount {
    private IAccount account;
    public AccountLogger(IAccount account){
        this.account = account;
    }


    public void preExecute(){
        System.out.println("Logging");
    }
    public void postExecute(){

    }


    @Override
    public void deposite(Transaction transaction) {
        // TODO Auto-generated method stub
        account.deposite(transaction);
        postExecute();
    }


    @Override
    public void withdraw(Transaction transaction) {
        // TODO Auto-generated method stub
        account.withdraw(transaction);
        postExecute();
    }


    @Override
    public void addInterest() {
        // TODO Auto-generated method stub
        account.addInterest();
        postExecute();
    }


    @Override
    public void evaluateTransaction(Transaction transaction) {
        // TODO Auto-generated method stub
        account.evaluateTransaction(transaction);
    }


    @Override
    public String generateReport() {
        return account.generateReport();
    }


	@Override
	public ICustomer getAccountOwner() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public double getAccountBalance() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getAccountNumber() {
		// TODO Auto-generated method stub
		return null;
	}


}



