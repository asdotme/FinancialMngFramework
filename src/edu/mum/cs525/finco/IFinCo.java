package edu.mum.cs525.finco;

import edu.mum.cs525.finco.accountsubsystem.controller.IAccountVisitor;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

/**
 * Created by asme on 2/6/17.
 */
public interface IFinCo {
    public void addAccount(IAccountVisitor accountVisitor, ICustomer customer);
    public void depositeMoney(IAccount account);
    public void withdrawMoney(IAccount account);
    public void addInterest();
    public void generateReport(IAccount account);
    }
