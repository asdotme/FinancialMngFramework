package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;

/**
 * Created by asme on 2/5/17.
 */
public class PersonEvaluatorFunctor extends EvaluateFunctor {
    @Override
    public boolean evaluateTransactionTemplate(ITransaction transaction, IAccount account) {
         if(transaction.getTransactionAmount()>500)
             if(account.getAccountBalance()<transaction.getTransactionAmount())
                 return true;

        return false;
    }
}
