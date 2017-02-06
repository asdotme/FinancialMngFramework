package finalproject.controller.account;

import finalproject.model.Transaction.ITransaction;
import finalproject.model.account.IAccount;

/**
 * Created by asme on 2/5/17.
 */
public class PersonEvaluatorFunctor extends EvaluateFunctor {
    @Override
    public boolean evaluateTransactionTemplate(ITransaction transaction, IAccount account) {
        return false;
    }
}
