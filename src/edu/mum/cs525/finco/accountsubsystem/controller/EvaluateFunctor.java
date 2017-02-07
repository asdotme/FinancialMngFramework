package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.Account;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.Transaction;

/**
 * Created by asme on 2/5/17.
 */
public abstract class EvaluateFunctor {

    public abstract boolean evaluateTransactionTemplate(Transaction transaction, Account account) ;

    public final void evaluateTemplate(Transaction transaction, Account account){
        sendEmail(account);
        evaluateTransactionTemplate(transaction, account);
    }

    private void sendEmail(IAccount count){
        System.out.println("sending email");

    }

}
