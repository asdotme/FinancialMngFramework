package edu.mum.cs525.ccard.accountsubsystem.model;

import edu.mum.cs525.finco.accountsubsystem.controller.EvaluateFunctor;
import edu.mum.cs525.finco.accountsubsystem.model.Account;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

/**
 * Created by asme on 2/7/17.
 */
public class GoldCCard extends CCardAccount {

    public GoldCCard(ICustomer accountOwner, String accountNumber, double accountInterestRate, EvaluateFunctor evaluateFunctor) {
        super(accountOwner, accountNumber, accountInterestRate, evaluateFunctor);
    }

    public GoldCCard(ICustomer accountOwner, String accountNumber, EvaluateFunctor evaluateFunctor) {

        super(accountOwner, accountNumber,0.06, evaluateFunctor);
    }

    public GoldCCard() {
    }

}
