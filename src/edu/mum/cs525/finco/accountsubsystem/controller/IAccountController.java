package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;

import java.util.Date;
import java.util.List;

public interface IAccountController {
    void createCompanyAccount(IAccountVisitor accountVisitor, ICompany company);
    void depositeMoney(IAccount iAccount, ITransaction iTransaction);
    void withdrawMoney(IAccount iAccount, ITransaction iTransaction);
    void addInterest(List<IAccount> iAccountList);
    void generateReport(IAccount iAccount, Date startDate, Date endDate);
}
