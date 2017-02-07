package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.accountsubsystem.model.Transaction;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;
import edu.mum.cs525.finco.dataaccesssubsystem.DataAccessSubSystem;

import java.util.Iterator;
import java.util.List;

public class AccountController implements IAccountController {
	@Override
	public void createCompanyAccount(IAccountVisitor accountVisitor,ICompany company,String accountNumber) {
		// TODO Auto-generated method stub
		accountVisitor.createAccount(company,accountNumber);
	}

	@Override
	public void createPersonAccount(IAccountVisitor accountVisitor,	IPerson person,String accountNumber) {
		accountVisitor.createAccount(person,accountNumber);
		
	}

	@Override
    public void addInterest() {
        List<IAccount> accountList= DataAccessSubSystem.getAccounts();
        Iterator<IAccount> accountIterator=accountList.iterator();
        while(accountIterator.hasNext()){
            accountIterator.next().addInterest();
        }
    }

    @Override
    public String generateReport(IAccount account) {
    	return account.generateReport();
    }

	@Override
	public void depositeMoney(ITransaction transaction, IAccount account) {
		// TODO Auto-generated method stub
		account.deposite((Transaction) transaction);
	}

	@Override
	public void withdrawMoney(ITransaction transaction, IAccount account) {
		// TODO Auto-generated method stub
		account.withdraw((Transaction) transaction);
	}
}
