package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;

import java.util.Date;
import java.util.List;

public class AccountController implements IAccountController {



    @Override
    public void createCompanyAccount(IAccountVisitor accountVisitor, ICustomer customer) {

    }

    @Override
    public void depositeMoney(IAccount account, ITransaction transaction) {

    }

    @Override
    public void withdrawMoney(IAccount account, ITransaction transaction) {

    }

    @Override
    public void addInterest(List<IAccount> iAccountList) {

    }

    @Override
    public void generateReport(IAccount account) {

    }
    private  double calculateInterest(double balance, double interest){

        return 0;
    }

}
