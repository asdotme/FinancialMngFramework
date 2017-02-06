package finalproject.controller.account;

import finalproject.model.Transaction.ITransaction;
import finalproject.model.account.IAccount;
import finalproject.model.customer.ICustomer;

/**
 * Created by asme on 2/5/17.
 */
public class CompanyEvaluatorFunctor extends EvaluateFunctor {
    @Override
    public boolean evaluateTransactionTemplate(ITransaction transaction, IAccount account) {

        return false;
    }
}
