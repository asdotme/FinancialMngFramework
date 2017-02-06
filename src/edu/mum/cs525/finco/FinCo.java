package edu.mum.cs525.finco;

import edu.mum.cs525.finco.accountsubsystem.controller.IAccountVisitor;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

/**
 * Created by asme on 2/6/17.
 */
public class FinCo implements IFinCo{

    @Override
    public void addAccount(IAccountVisitor accountVisitor, ICustomer customer) {

    }
    @Override
    public void depositeMoney(IAccount account) {

    }
    @Override
    public void withdrawMoney(IAccount account) {

    }
    @Override
    public void addInterest() {

    }
    @Override
    public void generateReport(IAccount account) {

    }


    public static void main (String []args){

    }

}
