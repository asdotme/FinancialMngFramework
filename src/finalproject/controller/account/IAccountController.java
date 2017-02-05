package finalproject.controller.account;

import finalproject.model.Transaction.ITransaction;
import finalproject.model.account.IAccount;
import finalproject.model.customer.ICustomer;

import java.util.Date;
import java.util.List;

public interface IAccountController {
    void createAccount(IAccount iAccount, ICustomer iCustomer);
    void depositeMoney(IAccount iAccount, ITransaction iTransaction);
    void withdrawMoney(IAccount iAccount, ITransaction iTransaction);
    void addInterest(List<IAccount> iAccountList);
    void generateReport(IAccount iAccount, Date startDate, Date endDate);
}
