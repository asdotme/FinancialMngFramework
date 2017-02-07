package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;

import java.util.Date;
import java.util.List;

public interface IAccountController {
    void createCompanyAccount(IAccountVisitor accountVisitor, ICustomer customer);
    void depositeMoney(ITransaction transaction);
    void withdrawMoney(ITransaction transaction);
    void addInterest();
    void generateReport(IAccount account);

}
