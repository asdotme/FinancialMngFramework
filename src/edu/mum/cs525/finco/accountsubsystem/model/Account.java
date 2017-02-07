package edu.mum.cs525.finco.accountsubsystem.model;

import edu.mum.cs525.finco.accountsubsystem.controller.EvaluateFunctor;
import edu.mum.cs525.finco.customersubsystem.model.Customer;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

import java.util.ArrayList;
import java.util.List;


public class Account implements IAccount{

    private Customer accountOwner;
    
    private String accountNumber;
    
    private double accountBalance;
    
    private double accountInterestRate;
    
    private EvaluateFunctor evaluateFunctor;

	private List<ITransaction> transactions;

    public Account(Customer accountOwner, String accountNumber,double accountInterestRate,EvaluateFunctor evaluateFunctor,
			List<ITransaction> transactions) {
		super();
		this.accountOwner = accountOwner;
		this.accountNumber = accountNumber;
		this.transactions = transactions;
		this.accountInterestRate=accountInterestRate;
		this.evaluateFunctor=evaluateFunctor;
		this.accountBalance=0.0;
	}

    public Account(Customer accountOwner, String accountNumber, EvaluateFunctor evaluateFunctor) {
		super();
		this.accountOwner = accountOwner;
		this.accountNumber = accountNumber;
		this.transactions = new ArrayList();
		this.accountInterestRate=0.0;
		this.accountBalance=0.0;
		this.evaluateFunctor=evaluateFunctor;
	}

	public Account(){
    	accountOwner=new Customer();
    	accountNumber="";
    	this.transactions = new ArrayList();
    	this.evaluateFunctor=null;
    }

	@Override
	public void deposite(Transaction transaction) {
		this.accountBalance+=transaction.getTransactionAmount();
		evaluateTransaction(transaction);
		transactions.add(transaction);
	}

	@Override
	public void withdraw(Transaction transaction) {
		this.accountBalance-=transaction.getTransactionAmount();
		evaluateTransaction(transaction);
		transactions.add(transaction);		
	}

	@Override
	public void addInterest() {
		double addAmount=this.accountBalance*(this.accountInterestRate);
		this.accountBalance+=addAmount;
		Transaction t=new Transaction(addAmount, TransactionType.AddingInterest);
		evaluateTransaction(t);
		transactions.add(t);				
	}

	@Override
	public String generateReport() {
		StringBuilder report=new StringBuilder();
		report.append("Account No.:"+this.accountNumber );
		report.append("Account Owner Name:"+this.accountOwner.getName());
		report.append("Account Balance:"+this.getAccountBalance() );
		for (int i = 0; i < this.getTransactions().size(); i++) {
			report.append("Account Transaction"+(i+1)+" :"+this.getAccountBalance() );
		}
		return report.toString();
	}
	
	@Override
	public void evaluateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		this.evaluateFunctor.evaluateTemplate(transaction, this);
	}
	

	
	
	public ICustomer getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(Customer accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<ITransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<ITransaction> transactions) {
		this.transactions = transactions;
	}

	public void addAccountTransactions(ITransaction transaction) {
		transactions.add(transaction);
	}
}
