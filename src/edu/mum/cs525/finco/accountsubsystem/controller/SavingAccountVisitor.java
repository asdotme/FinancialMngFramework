package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;

public class SavingAccountVisitor implements IAccountVisitor {
    @Override
    public void createAccount(IPerson iPerson) {

    }

    @Override
    public void createAccount(ICompany iCompany) {

    }
}
