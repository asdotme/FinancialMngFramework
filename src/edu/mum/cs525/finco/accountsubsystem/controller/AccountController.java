package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.model.Transaction.ITransaction;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;

import java.util.Date;
import java.util.List;

public class AccountController implements IAccountController {
    @Override
    public void createPesonalAccount(IAccountVisitor accountVisitor, IPerson person) {

        accountVisitor.createAccount(person);

    }
    public void createCompanyAccount(IAccountVisitor accountVisitor, ICompany company) {

        accountVisitor.createAccount(company);

    }

    @Override
    public void depositeMoney(IAccount iAccount, ITransaction iTransaction) {

    }

    @Override
    public void withdrawMoney(IAccount iAccount, ITransaction iTransaction) {

    }

    @Override
    public void addInterest(List<IAccount> iAccountList) {

    }

    @Override
    public void generateReport(IAccount iAccount, Date startDate, Date endDate) {

    }


}
