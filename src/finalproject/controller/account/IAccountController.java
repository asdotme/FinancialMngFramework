package finalproject.controller.account;

import finalproject.model.Transaction.ITransaction;
import finalproject.model.account.IAccount;
import finalproject.model.customer.ICompany;
import finalproject.model.customer.ICustomer;
import finalproject.model.customer.IPerson;

import java.util.Date;
import java.util.List;

public interface IAccountController {
    void createCompanyAccount(IAccountVisitor accountVisitor, ICompany company);
    void createPesonalAccount(IAccountVisitor accountVisitor, IPerson person);
    void depositeMoney(IAccount iAccount, ITransaction iTransaction);
    void withdrawMoney(IAccount iAccount, ITransaction iTransaction);
    void addInterest(List<IAccount> iAccountList);
    void generateReport(IAccount iAccount, Date startDate, Date endDate);
}
