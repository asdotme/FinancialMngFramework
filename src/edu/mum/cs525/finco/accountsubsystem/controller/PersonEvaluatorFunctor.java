package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.Account;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.accountsubsystem.model.Transaction;

/**
 * Created by asme on 2/5/17.
 */
public class PersonEvaluatorFunctor extends EvaluateFunctor {
    @Override
    public boolean evaluateTransactionTemplate(Transaction transaction, Account account) {
        return (transaction.getTransactionAmount()>500 || account.getAccountBalance()<transaction.getTransactionAmount())?true:false;
    }
}
