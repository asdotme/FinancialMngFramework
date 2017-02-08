package edu.mum.cs525.finco.accountsubsystem.model;

import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

public  class AccountLogger implements IAccount {
    private IAccount account;
    public AccountLogger(IAccount account){
        this.account = account;
    }


    public void preExecute(){
        System.out.println("Pre Operation Logging");
    }
    public void postExecute(){
        System.out.println("Post Operation Logging");
    }


    @Override
    public void deposite(ITransaction transaction) {
        // TODO Auto-generated method stub
        preExecute();
        account.deposite(transaction);
        postExecute();
    }


    @Override
    public void withdraw(ITransaction transaction) {
        // TODO Auto-generated method stub
        preExecute();
        account.withdraw(transaction);
        postExecute();
    }


    @Override
    public void addInterest() {
        // TODO Auto-generated method stub
        preExecute();
        account.addInterest();
        postExecute();
    }


    @Override
    public void evaluateTransaction(ITransaction transaction) {
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


	@Override
	public String getAccountType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setAccountType(String accountType) {
		// TODO Auto-generated method stub
		
	}


}



