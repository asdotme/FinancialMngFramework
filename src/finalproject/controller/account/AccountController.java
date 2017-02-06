package finalproject.controller.account;

import finalproject.model.Transaction.ITransaction;
import finalproject.model.account.IAccount;
import finalproject.model.customer.ICompany;
import finalproject.model.customer.ICustomer;
import finalproject.model.customer.IPerson;

import java.util.Date;
import java.util.List;

public class AccountController implements IAccountController {
    @Override
    public void createPesonalAccount(IAccountVisitor accountVisitor, IPerson person) {

        accountVisitor.createAccount(person);

    }
    public void createCompanyAccount(IAccountVisitor accountVisitor, ICompany company) {

        accountVisitor.createAccount(company);

    }

    @Override
    public void depositeMoney(IAccount iAccount, ITransaction iTransaction) {

    }

    @Override
    public void withdrawMoney(IAccount iAccount, ITransaction iTransaction) {

    }

    @Override
    public void addInterest(List<IAccount> iAccountList) {

    }

    @Override
    public void generateReport(IAccount iAccount, Date startDate, Date endDate) {

    }


}
