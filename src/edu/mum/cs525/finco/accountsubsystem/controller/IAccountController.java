package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;

import java.util.Date;
import java.util.List;

public interface IAccountController {
    void createCompanyAccount(IAccountVisitor accountVisitor, ICompany company,String accountNumber);
    void createPersonAccount(IAccountVisitor accountVisitor, IPerson person,String accountNumber);
    void depositeMoney(ITransaction transaction,IAccount account);
    void withdrawMoney(ITransaction transaction,IAccount account);
    void addInterest();
    String generateReport(IAccount account);
}
