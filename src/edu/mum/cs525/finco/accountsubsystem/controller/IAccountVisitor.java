package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;

public interface IAccountVisitor {
    void createAccount(IPerson iPerson);
    void createAccount(ICompany iCompany);

}
