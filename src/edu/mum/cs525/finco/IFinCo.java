package edu.mum.cs525.finco;

import javax.swing.table.DefaultTableModel;

import edu.mum.cs525.finco.accountsubsystem.controller.EvaluateFunctor;
import edu.mum.cs525.finco.accountsubsystem.controller.IAccountVisitor;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;

/**
 * Created by asme on 2/6/17.
 */
public interface IFinCo {
    public void addCompanyAccount(IAccountVisitor accountVisitor, ICompany company,String accountNumber);
    public void addPersonAccount(IAccountVisitor accountVisitor, IPerson person,String accountNumber);
    public void depositeMoney(IAccount account, ITransaction transaction);
    public void withdrawMoney(IAccount account, ITransaction transaction);
    public void addInterest();
    public String generateReport(IAccount account);
    public DefaultTableModel getDefaultTableModel();
   /* public void withdrawMoney(IAccount account, int rowIndex, double parseDouble);
    public void addCustomer(ICustomer customer);*/
    public void setEvaluateFuctor(EvaluateFunctor evaluateFuctor);
}
