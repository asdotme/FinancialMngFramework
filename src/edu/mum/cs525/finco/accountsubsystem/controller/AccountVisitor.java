package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.Account;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.customersubsystem.model.Customer;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;

/**
 * Created by asme on 2/6/17.
 */
public class AccountVisitor implements IAccountVisitor {
    @Override
    public IAccount createAccount(IPerson person,String accountNumber) {
    	return new Account((Customer) person,accountNumber, new PersonEvaluatorFunctor());
    }

    @Override
    public IAccount createAccount(ICompany company,String accountNumber) {
    	return new Account((Customer) company,accountNumber, new PersonEvaluatorFunctor());
    }
}
