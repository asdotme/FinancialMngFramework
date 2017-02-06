package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.model.Transaction.ITransaction;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;

/**
 * Created by asme on 2/5/17.
 */
public class CompanyEvaluatorFunctor extends EvaluateFunctor {
    @Override
    public boolean evaluateTransactionTemplate(ITransaction transaction, IAccount account) {

        return false;
    }
}
