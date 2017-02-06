package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;

/**
 * Created by asme on 2/5/17.
 */
public abstract class EvaluateFunctor {
//    public final boolean evaluateTransactionTemplate(ICompany company) {
//        sendEmail(company);
//        return false;
//    }
//
//    public final boolean evaluateTransactionTemplate(IPerson person) {
//        sendEmail(person);
//        return false;
//    }
//    public abstract boolean evaluateTransactionTemplate(ICompany company);

    public abstract boolean evaluateTransactionTemplate(ITransaction transaction, IAccount account) ;


    public final void evaluateTemplate(ITransaction transaction, IAccount account){
        sendEmail(account);
        evaluateTransactionTemplate(transaction, account);
    }




    private void sendEmail(IAccount count){
        System.out.println("sending email");

    }


}
