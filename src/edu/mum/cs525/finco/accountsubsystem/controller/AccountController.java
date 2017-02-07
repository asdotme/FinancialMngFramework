package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;
import edu.mum.cs525.finco.dataaccesssubsystem.DataAccessSubSystem;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AccountController implements IAccountController {



    @Override
    public void createCompanyAccount(IAccountVisitor accountVisitor, ICustomer customer) {

    }

    @Override
    public void depositeMoney(ITransaction transaction) {

    }

    @Override
    public void withdrawMoney(ITransaction transaction) {

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
    public void generateReport(IAccount account) {

    }

}
