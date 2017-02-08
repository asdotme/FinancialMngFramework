package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;

/**
 * Created by asme on 2/5/17.
 */
public class CompanyEvaluatorFunctor extends EvaluateFunctor {

    @Override
    public boolean evaluateTransactionTemplate(ITransaction transaction, IAccount account) {
        return true;
    }
}
